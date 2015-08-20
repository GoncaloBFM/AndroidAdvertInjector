.class public Landroid/support/v4/view/ViewPropertyAnimatorCompat;
.super Ljava/lang/Object;
.source "ViewPropertyAnimatorCompat.java"


# static fields
.field static final a:Landroid/support/v4/view/ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl;


# instance fields
.field private b:Ljava/lang/Runnable;

.field private c:Ljava/lang/Runnable;

.field private d:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 596
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 597
    const/16 v1, 0x13

    if-lt v0, v1, :cond_0

    .line 598
    new-instance v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->a:Landroid/support/v4/view/ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl;

    .line 608
    :goto_0
    return-void

    .line 599
    :cond_0
    const/16 v1, 0x12

    if-lt v0, v1, :cond_1

    .line 600
    new-instance v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->a:Landroid/support/v4/view/ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl;

    goto :goto_0

    .line 601
    :cond_1
    const/16 v1, 0x10

    if-lt v0, v1, :cond_2

    .line 602
    new-instance v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->a:Landroid/support/v4/view/ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl;

    goto :goto_0

    .line 603
    :cond_2
    const/16 v1, 0xe

    if-lt v0, v1, :cond_3

    .line 604
    new-instance v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->a:Landroid/support/v4/view/ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl;

    goto :goto_0

    .line 606
    :cond_3
    new-instance v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->a:Landroid/support/v4/view/ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl;

    goto :goto_0
.end method

.method static synthetic a(Landroid/support/v4/view/ViewPropertyAnimatorCompat;I)I
    .locals 0

    .prologue
    .line 24
    iput p1, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->d:I

    return p1
.end method

.method static synthetic a(Landroid/support/v4/view/ViewPropertyAnimatorCompat;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->b:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic b(Landroid/support/v4/view/ViewPropertyAnimatorCompat;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->c:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic c(Landroid/support/v4/view/ViewPropertyAnimatorCompat;)I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Landroid/support/v4/view/ViewPropertyAnimatorCompat;->d:I

    return v0
.end method
