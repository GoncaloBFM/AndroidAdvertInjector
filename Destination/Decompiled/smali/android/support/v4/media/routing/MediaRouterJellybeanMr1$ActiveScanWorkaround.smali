.class public final Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$ActiveScanWorkaround;
.super Ljava/lang/Object;
.source "MediaRouterJellybeanMr1.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final a:Landroid/hardware/display/DisplayManager;

.field private final b:Landroid/os/Handler;

.field private c:Ljava/lang/reflect/Method;

.field private d:Z


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 108
    iget-boolean v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$ActiveScanWorkaround;->d:Z

    if-eqz v0, :cond_0

    .line 110
    :try_start_0
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$ActiveScanWorkaround;->c:Ljava/lang/reflect/Method;

    iget-object v1, p0, Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$ActiveScanWorkaround;->a:Landroid/hardware/display/DisplayManager;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_1

    .line 116
    :goto_0
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$ActiveScanWorkaround;->b:Landroid/os/Handler;

    const-wide/16 v2, 0x3a98

    invoke-virtual {v0, p0, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 118
    :cond_0
    return-void

    .line 111
    :catch_0
    move-exception v0

    .line 112
    const-string v1, "MediaRouterJellybeanMr1"

    const-string v2, "Cannot scan for wifi displays."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 113
    :catch_1
    move-exception v0

    .line 114
    const-string v1, "MediaRouterJellybeanMr1"

    const-string v2, "Cannot scan for wifi displays."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
