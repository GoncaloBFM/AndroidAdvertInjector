.class Landroid/support/v4/media/TransportMediator$1;
.super Ljava/lang/Object;
.source "TransportMediator.java"

# interfaces
.implements Landroid/support/v4/media/TransportMediatorCallback;


# instance fields
.field final synthetic a:Landroid/support/v4/media/TransportMediator;


# virtual methods
.method public a()J
    .locals 2

    .prologue
    .line 70
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator$1;->a:Landroid/support/v4/media/TransportMediator;

    iget-object v0, v0, Landroid/support/v4/media/TransportMediator;->a:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->d()J

    move-result-wide v0

    return-wide v0
.end method

.method public a(I)V
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator$1;->a:Landroid/support/v4/media/TransportMediator;

    iget-object v0, v0, Landroid/support/v4/media/TransportMediator;->a:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0, p1}, Landroid/support/v4/media/TransportPerformer;->a(I)V

    .line 66
    return-void
.end method

.method public a(J)V
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator$1;->a:Landroid/support/v4/media/TransportMediator;

    iget-object v0, v0, Landroid/support/v4/media/TransportMediator;->a:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0, p1, p2}, Landroid/support/v4/media/TransportPerformer;->a(J)V

    .line 76
    return-void
.end method

.method public a(Landroid/view/KeyEvent;)V
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Landroid/support/v4/media/TransportMediator$1;->a:Landroid/support/v4/media/TransportMediator;

    iget-object v0, v0, Landroid/support/v4/media/TransportMediator;->b:Landroid/view/KeyEvent$Callback;

    invoke-virtual {p1, v0}, Landroid/view/KeyEvent;->dispatch(Landroid/view/KeyEvent$Callback;)Z

    .line 62
    return-void
.end method
