.class public Landroid/support/v4/widget/PopupWindowCompat;
.super Ljava/lang/Object;
.source "PopupWindowCompat.java"


# static fields
.field static final a:Landroid/support/v4/widget/PopupWindowCompat$PopupWindowImpl;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 63
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 64
    const/16 v1, 0x13

    if-lt v0, v1, :cond_0

    .line 65
    new-instance v0, Landroid/support/v4/widget/PopupWindowCompat$KitKatPopupWindowImpl;

    invoke-direct {v0}, Landroid/support/v4/widget/PopupWindowCompat$KitKatPopupWindowImpl;-><init>()V

    sput-object v0, Landroid/support/v4/widget/PopupWindowCompat;->a:Landroid/support/v4/widget/PopupWindowCompat$PopupWindowImpl;

    .line 69
    :goto_0
    return-void

    .line 67
    :cond_0
    new-instance v0, Landroid/support/v4/widget/PopupWindowCompat$BasePopupWindowImpl;

    invoke-direct {v0}, Landroid/support/v4/widget/PopupWindowCompat$BasePopupWindowImpl;-><init>()V

    sput-object v0, Landroid/support/v4/widget/PopupWindowCompat;->a:Landroid/support/v4/widget/PopupWindowCompat$PopupWindowImpl;

    goto :goto_0
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    return-void
.end method
