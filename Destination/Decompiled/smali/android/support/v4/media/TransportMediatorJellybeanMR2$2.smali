.class Landroid/support/v4/media/TransportMediatorJellybeanMR2$2;
.super Ljava/lang/Object;
.source "TransportMediatorJellybeanMR2.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;


# instance fields
.field final synthetic a:Landroid/support/v4/media/TransportMediatorJellybeanMR2;


# virtual methods
.method public onWindowFocusChanged(Z)V
    .locals 1

    .prologue
    .line 56
    if-eqz p1, :cond_0

    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2$2;->a:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->b()V

    .line 58
    :goto_0
    return-void

    .line 57
    :cond_0
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2$2;->a:Landroid/support/v4/media/TransportMediatorJellybeanMR2;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->e()V

    goto :goto_0
.end method
