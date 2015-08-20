.class final Landroid/support/v4/view/ViewPropertyAnimatorCompatKK$1;
.super Ljava/lang/Object;
.source "ViewPropertyAnimatorCompatKK.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# instance fields
.field final synthetic a:Landroid/support/v4/view/ViewPropertyAnimatorUpdateListener;

.field final synthetic b:Landroid/view/View;


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 2

    .prologue
    .line 28
    iget-object v0, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompatKK$1;->a:Landroid/support/v4/view/ViewPropertyAnimatorUpdateListener;

    iget-object v1, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompatKK$1;->b:Landroid/view/View;

    invoke-interface {v0, v1}, Landroid/support/v4/view/ViewPropertyAnimatorUpdateListener;->a(Landroid/view/View;)V

    .line 29
    return-void
.end method
