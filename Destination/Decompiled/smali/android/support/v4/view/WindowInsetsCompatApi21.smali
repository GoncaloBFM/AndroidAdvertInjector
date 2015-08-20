.class Landroid/support/v4/view/WindowInsetsCompatApi21;
.super Landroid/support/v4/view/WindowInsetsCompat;
.source "WindowInsetsCompatApi21.java"


# instance fields
.field private final a:Landroid/view/WindowInsets;


# direct methods
.method constructor <init>(Landroid/view/WindowInsets;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/support/v4/view/WindowInsetsCompat;-><init>()V

    .line 27
    iput-object p1, p0, Landroid/support/v4/view/WindowInsetsCompatApi21;->a:Landroid/view/WindowInsets;

    .line 28
    return-void
.end method


# virtual methods
.method a()Landroid/view/WindowInsets;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Landroid/support/v4/view/WindowInsetsCompatApi21;->a:Landroid/view/WindowInsets;

    return-object v0
.end method
