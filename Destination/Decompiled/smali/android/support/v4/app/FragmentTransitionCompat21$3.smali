.class final Landroid/support/v4/app/FragmentTransitionCompat21$3;
.super Landroid/transition/Transition$EpicenterCallback;
.source "FragmentTransitionCompat21.java"


# instance fields
.field final synthetic a:Landroid/support/v4/app/FragmentTransitionCompat21$EpicenterView;

.field private b:Landroid/graphics/Rect;


# direct methods
.method constructor <init>(Landroid/support/v4/app/FragmentTransitionCompat21$EpicenterView;)V
    .locals 0

    .prologue
    .line 207
    iput-object p1, p0, Landroid/support/v4/app/FragmentTransitionCompat21$3;->a:Landroid/support/v4/app/FragmentTransitionCompat21$EpicenterView;

    invoke-direct {p0}, Landroid/transition/Transition$EpicenterCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onGetEpicenter(Landroid/transition/Transition;)Landroid/graphics/Rect;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Landroid/support/v4/app/FragmentTransitionCompat21$3;->b:Landroid/graphics/Rect;

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/app/FragmentTransitionCompat21$3;->a:Landroid/support/v4/app/FragmentTransitionCompat21$EpicenterView;

    iget-object v0, v0, Landroid/support/v4/app/FragmentTransitionCompat21$EpicenterView;->a:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 213
    iget-object v0, p0, Landroid/support/v4/app/FragmentTransitionCompat21$3;->a:Landroid/support/v4/app/FragmentTransitionCompat21$EpicenterView;

    iget-object v0, v0, Landroid/support/v4/app/FragmentTransitionCompat21$EpicenterView;->a:Landroid/view/View;

    invoke-static {v0}, Landroid/support/v4/app/FragmentTransitionCompat21;->b(Landroid/view/View;)Landroid/graphics/Rect;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/FragmentTransitionCompat21$3;->b:Landroid/graphics/Rect;

    .line 215
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/FragmentTransitionCompat21$3;->b:Landroid/graphics/Rect;

    return-object v0
.end method
