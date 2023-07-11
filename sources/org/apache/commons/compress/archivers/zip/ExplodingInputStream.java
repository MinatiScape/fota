package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* loaded from: classes.dex */
class ExplodingInputStream extends InputStream {
    private BitStream bits;
    private final CircularBuffer buffer = new CircularBuffer(32768);
    private final int dictionarySize;
    private BinaryTree distanceTree;
    private final InputStream in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;

    public ExplodingInputStream(int i, int i2, InputStream inputStream) {
        if (i != 4096 && i != 8192) {
            throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
        }
        if (i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("The number of trees must be 2 or 3");
        }
        this.dictionarySize = i;
        this.numberOfTrees = i2;
        this.minimumMatchLength = i2;
        this.in = inputStream;
    }

    private void fillBuffer() throws IOException {
        int nextBits;
        init();
        int nextBit = this.bits.nextBit();
        if (nextBit == 1) {
            BinaryTree binaryTree = this.literalTree;
            if (binaryTree != null) {
                nextBits = binaryTree.read(this.bits);
            } else {
                nextBits = this.bits.nextBits(8);
            }
            if (nextBits == -1) {
                return;
            }
            this.buffer.put(nextBits);
        } else if (nextBit == 0) {
            int i = this.dictionarySize == 4096 ? 6 : 7;
            int nextBits2 = this.bits.nextBits(i);
            int read = this.distanceTree.read(this.bits);
            if (read != -1 || nextBits2 > 0) {
                int i2 = (read << i) | nextBits2;
                int read2 = this.lengthTree.read(this.bits);
                if (read2 == 63) {
                    read2 += this.bits.nextBits(8);
                }
                this.buffer.copy(i2 + 1, read2 + this.minimumMatchLength);
            }
        }
    }

    private void init() throws IOException {
        if (this.bits == null) {
            if (this.numberOfTrees == 3) {
                this.literalTree = BinaryTree.decode(this.in, CpioConstants.C_IRUSR);
            }
            this.lengthTree = BinaryTree.decode(this.in, 64);
            this.distanceTree = BinaryTree.decode(this.in, 64);
            this.bits = new BitStream(this.in);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.buffer.available()) {
            fillBuffer();
        }
        return this.buffer.get();
    }
}
