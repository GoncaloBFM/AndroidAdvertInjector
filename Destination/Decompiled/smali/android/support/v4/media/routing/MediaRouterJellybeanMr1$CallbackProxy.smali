.class Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$CallbackProxy;
.super Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;
.source "MediaRouterJellybeanMr1.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$Callback;",
        ">",
        "Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy",
        "<TT;>;"
    }
.end annotation


# virtual methods
.method public onRoutePresentationDisplayChanged(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    check-cast v0, Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$Callback;

    invoke-interface {v0, p2}, Landroid/support/v4/media/routing/MediaRouterJellybeanMr1$Callback;->e(Ljava/lang/Object;)V

    .line 174
    return-void
.end method
