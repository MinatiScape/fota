package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;
/* compiled from: ImageViewUtils.java */
/* loaded from: classes.dex */
class F extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageView f916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(ImageView imageView) {
        this.f916a = imageView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ImageView.ScaleType scaleType = (ImageView.ScaleType) this.f916a.getTag(R$id.save_scale_type);
        this.f916a.setScaleType(scaleType);
        this.f916a.setTag(R$id.save_scale_type, null);
        if (scaleType == ImageView.ScaleType.MATRIX) {
            ImageView imageView = this.f916a;
            imageView.setImageMatrix((Matrix) imageView.getTag(R$id.save_image_matrix));
            this.f916a.setTag(R$id.save_image_matrix, null);
        }
        animator.removeListener(this);
    }
}
