.class final Landroid/support/v4/view/ViewPropertyAnimatorCompatICS$1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "ViewPropertyAnimatorCompatICS.java"


# instance fields
.field final synthetic a:Landroid/support/v4/view/ViewPropertyAnimatorListener;

.field final synthetic b:Landroid/view/View;


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 139
    iget-object v0, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompatICS$1;->a:Landroid/support/v4/view/ViewPropertyAnimatorListener;

    iget-object v1, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompatICS$1;->b:Landroid/view/View;

    invoke-interface {v0, v1}, Landroid/support/v4/view/ViewPropertyAnimatorListener;->c(Landroid/view/View;)V

    .line 140
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 144
    iget-object v0, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompatICS$1;->a:Landroid/support/v4/view/ViewPropertyAnimatorListener;

    iget-object v1, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompatICS$1;->b:Landroid/view/View;

    invoke-interface {v0, v1}, Landroid/support/v4/view/ViewPropertyAnimatorListener;->b(Landroid/view/View;)V

    .line 145
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 149
    iget-object v0, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompatICS$1;->a:Landroid/support/v4/view/ViewPropertyAnimatorListener;

    iget-object v1, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompatICS$1;->b:Landroid/view/View;

    invoke-interface {v0, v1}, Landroid/support/v4/view/ViewPropertyAnimatorListener;->a(Landroid/view/View;)V

    .line 150
    return-void
.end method
