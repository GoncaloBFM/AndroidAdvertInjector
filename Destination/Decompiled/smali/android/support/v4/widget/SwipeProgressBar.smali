.class final Landroid/support/v4/widget/SwipeProgressBar;
.super Ljava/lang/Object;
.source "SwipeProgressBar.java"


# static fields
.field private static final a:Landroid/view/animation/Interpolator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    invoke-static {}, Landroid/support/v4/widget/BakedBezierInterpolator;->a()Landroid/support/v4/widget/BakedBezierInterpolator;

    move-result-object v0

    sput-object v0, Landroid/support/v4/widget/SwipeProgressBar;->a:Landroid/view/animation/Interpolator;

    return-void
.end method
