.class public Landroid/support/v4/view/MarginLayoutParamsCompat;
.super Ljava/lang/Object;
.source "MarginLayoutParamsCompat.java"


# static fields
.field static final a:Landroid/support/v4/view/MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 127
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 128
    const/16 v1, 0x11

    if-lt v0, v1, :cond_0

    .line 129
    new-instance v0, Landroid/support/v4/view/MarginLayoutParamsCompat$MarginLayoutParamsCompatImplJbMr1;

    invoke-direct {v0}, Landroid/support/v4/view/MarginLayoutParamsCompat$MarginLayoutParamsCompatImplJbMr1;-><init>()V

    sput-object v0, Landroid/support/v4/view/MarginLayoutParamsCompat;->a:Landroid/support/v4/view/MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl;

    .line 133
    :goto_0
    return-void

    .line 131
    :cond_0
    new-instance v0, Landroid/support/v4/view/MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase;

    invoke-direct {v0}, Landroid/support/v4/view/MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase;-><init>()V

    sput-object v0, Landroid/support/v4/view/MarginLayoutParamsCompat;->a:Landroid/support/v4/view/MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl;

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    return-void
.end method
