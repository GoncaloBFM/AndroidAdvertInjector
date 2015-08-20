.class public abstract Landroid/support/v4/media/session/MediaSessionCompat$Callback;
.super Ljava/lang/Object;
.source "MediaSessionCompat.java"


# instance fields
.field final a:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 268
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 269
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 270
    new-instance v0, Landroid/support/v4/media/session/MediaSessionCompat$Callback$StubApi21;

    invoke-direct {v0, p0, v2}, Landroid/support/v4/media/session/MediaSessionCompat$Callback$StubApi21;-><init>(Landroid/support/v4/media/session/MediaSessionCompat$Callback;Landroid/support/v4/media/session/MediaSessionCompat$1;)V

    invoke-static {v0}, Landroid/support/v4/media/session/MediaSessionCompatApi21;->a(Landroid/support/v4/media/session/MediaSessionCompatApi21$Callback;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/media/session/MediaSessionCompat$Callback;->a:Ljava/lang/Object;

    .line 274
    :goto_0
    return-void

    .line 272
    :cond_0
    iput-object v2, p0, Landroid/support/v4/media/session/MediaSessionCompat$Callback;->a:Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 0

    .prologue
    .line 302
    return-void
.end method

.method public a(J)V
    .locals 0

    .prologue
    .line 346
    return-void
.end method

.method public a(Landroid/support/v4/media/RatingCompat;)V
    .locals 0

    .prologue
    .line 354
    return-void
.end method

.method public a(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/ResultReceiver;)V
    .locals 0

    .prologue
    .line 286
    return-void
.end method

.method public a(Landroid/content/Intent;)Z
    .locals 1

    .prologue
    .line 295
    const/4 v0, 0x0

    return v0
.end method

.method public b()V
    .locals 0

    .prologue
    .line 308
    return-void
.end method

.method public c()V
    .locals 0

    .prologue
    .line 314
    return-void
.end method

.method public d()V
    .locals 0

    .prologue
    .line 320
    return-void
.end method

.method public e()V
    .locals 0

    .prologue
    .line 326
    return-void
.end method

.method public f()V
    .locals 0

    .prologue
    .line 332
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 338
    return-void
.end method
