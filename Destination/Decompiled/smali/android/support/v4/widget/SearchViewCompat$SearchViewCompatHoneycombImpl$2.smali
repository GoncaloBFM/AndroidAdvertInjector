.class Landroid/support/v4/widget/SearchViewCompat$SearchViewCompatHoneycombImpl$2;
.super Ljava/lang/Object;
.source "SearchViewCompat.java"

# interfaces
.implements Landroid/support/v4/widget/SearchViewCompatHoneycomb$OnCloseListenerCompatBridge;


# instance fields
.field final synthetic a:Landroid/support/v4/widget/SearchViewCompat$OnCloseListenerCompat;

.field final synthetic b:Landroid/support/v4/widget/SearchViewCompat$SearchViewCompatHoneycombImpl;


# direct methods
.method constructor <init>(Landroid/support/v4/widget/SearchViewCompat$SearchViewCompatHoneycombImpl;Landroid/support/v4/widget/SearchViewCompat$OnCloseListenerCompat;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Landroid/support/v4/widget/SearchViewCompat$SearchViewCompatHoneycombImpl$2;->b:Landroid/support/v4/widget/SearchViewCompat$SearchViewCompatHoneycombImpl;

    iput-object p2, p0, Landroid/support/v4/widget/SearchViewCompat$SearchViewCompatHoneycombImpl$2;->a:Landroid/support/v4/widget/SearchViewCompat$OnCloseListenerCompat;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClose()Z
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Landroid/support/v4/widget/SearchViewCompat$SearchViewCompatHoneycombImpl$2;->a:Landroid/support/v4/widget/SearchViewCompat$OnCloseListenerCompat;

    invoke-virtual {v0}, Landroid/support/v4/widget/SearchViewCompat$OnCloseListenerCompat;->onClose()Z

    move-result v0

    return v0
.end method
