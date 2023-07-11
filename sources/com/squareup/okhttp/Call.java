package com.squareup.okhttp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class Call {
    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        ApplicationInterceptorChain(int i, Request request, boolean z) {
            this.index = i;
            this.request = request;
            this.forWebSocket = z;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return null;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) throws IOException {
            if (this.index < Call.this.client.interceptors().size()) {
                ApplicationInterceptorChain applicationInterceptorChain = new ApplicationInterceptorChain(this.index + 1, request, this.forWebSocket);
                Interceptor interceptor = Call.this.client.interceptors().get(this.index);
                Response intercept = interceptor.intercept(applicationInterceptorChain);
                if (intercept != null) {
                    return intercept;
                }
                throw new NullPointerException("application interceptor " + interceptor + " returned null");
            }
            return Call.this.getResponse(request, this.forWebSocket);
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void cancel() {
            Call.this.cancel();
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void execute() {
            IOException e;
            Response responseWithInterceptorChain;
            boolean z = true;
            try {
                try {
                    responseWithInterceptorChain = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (Call.this.canceled) {
                        this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                    } else {
                        this.responseCallback.onResponse(responseWithInterceptorChain);
                    }
                } catch (IOException e3) {
                    e = e3;
                    if (z) {
                        Logger logger = Internal.logger;
                        Level level = Level.INFO;
                        logger.log(level, "Callback failure for " + Call.this.toLoggableString(), (Throwable) e);
                    } else {
                        this.responseCallback.onFailure(Call.this.engine == null ? Call.this.originalRequest : Call.this.engine.getRequest(), e);
                    }
                }
            } finally {
                Call.this.client.getDispatcher().finished(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Call get() {
            return Call.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String host() {
            return Call.this.originalRequest.httpUrl().host();
        }

        Request request() {
            return Call.this.originalRequest;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Object tag() {
            return Call.this.originalRequest.tag();
        }

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean z) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z).proceed(this.originalRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toLoggableString() {
        String str = this.canceled ? "canceled call" : "call";
        HttpUrl resolve = this.originalRequest.httpUrl().resolve("/...");
        return str + " to " + resolve;
    }

    public void cancel() {
        this.canceled = true;
        HttpEngine httpEngine = this.engine;
        if (httpEngine != null) {
            httpEngine.cancel();
        }
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    com.squareup.okhttp.Response getResponse(com.squareup.okhttp.Request r13, boolean r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Call.getResponse(com.squareup.okhttp.Request, boolean):com.squareup.okhttp.Response");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object tag() {
        return this.originalRequest.tag();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueue(Callback callback, boolean z) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback, z));
    }
}
