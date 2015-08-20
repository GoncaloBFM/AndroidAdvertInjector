.class Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;
.super Landroid/media/MediaRouter$Callback;
.source "MediaRouterJellybean.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;",
        ">",
        "Landroid/media/MediaRouter$Callback;"
    }
.end annotation


# instance fields
.field protected final a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# virtual methods
.method public onRouteAdded(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .locals 1

    .prologue
    .line 386
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    invoke-interface {v0, p2}, Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;->a(Ljava/lang/Object;)V

    .line 387
    return-void
.end method

.method public onRouteChanged(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .locals 1

    .prologue
    .line 398
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    invoke-interface {v0, p2}, Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;->c(Ljava/lang/Object;)V

    .line 399
    return-void
.end method

.method public onRouteGrouped(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;Landroid/media/MediaRouter$RouteGroup;I)V
    .locals 1

    .prologue
    .line 405
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    invoke-interface {v0, p2, p3, p4}, Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;->a(Ljava/lang/Object;Ljava/lang/Object;I)V

    .line 406
    return-void
.end method

.method public onRouteRemoved(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    invoke-interface {v0, p2}, Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;->b(Ljava/lang/Object;)V

    .line 393
    return-void
.end method

.method public onRouteSelected(Landroid/media/MediaRouter;ILandroid/media/MediaRouter$RouteInfo;)V
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    invoke-interface {v0, p2, p3}, Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;->a(ILjava/lang/Object;)V

    .line 375
    return-void
.end method

.method public onRouteUngrouped(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;Landroid/media/MediaRouter$RouteGroup;)V
    .locals 1

    .prologue
    .line 412
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    invoke-interface {v0, p2, p3}, Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;->a(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 413
    return-void
.end method

.method public onRouteUnselected(Landroid/media/MediaRouter;ILandroid/media/MediaRouter$RouteInfo;)V
    .locals 1

    .prologue
    .line 380
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    invoke-interface {v0, p2, p3}, Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;->b(ILjava/lang/Object;)V

    .line 381
    return-void
.end method

.method public onRouteVolumeChanged(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .locals 1

    .prologue
    .line 418
    iget-object v0, p0, Landroid/support/v4/media/routing/MediaRouterJellybean$CallbackProxy;->a:Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;

    invoke-interface {v0, p2}, Landroid/support/v4/media/routing/MediaRouterJellybean$Callback;->d(Ljava/lang/Object;)V

    .line 419
    return-void
.end method
