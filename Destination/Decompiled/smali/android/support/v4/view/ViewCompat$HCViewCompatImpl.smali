.class Landroid/support/v4/view/ViewCompat$HCViewCompatImpl;
.super Landroid/support/v4/view/ViewCompat$GBViewCompatImpl;
.source "ViewCompat.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 752
    invoke-direct {p0}, Landroid/support/v4/view/ViewCompat$GBViewCompatImpl;-><init>()V

    return-void
.end method


# virtual methods
.method a()J
    .locals 2

    .prologue
    .line 755
    invoke-static {}, Landroid/support/v4/view/ViewCompatHC;->a()J

    move-result-wide v0

    return-wide v0
.end method

.method public a(Landroid/view/View;ILandroid/graphics/Paint;)V
    .locals 0

    .prologue
    .line 763
    invoke-static {p1, p2, p3}, Landroid/support/v4/view/ViewCompatHC;->a(Landroid/view/View;ILandroid/graphics/Paint;)V

    .line 764
    return-void
.end method

.method public a(Landroid/view/View;Landroid/graphics/Paint;)V
    .locals 1

    .prologue
    .line 773
    invoke-virtual {p0, p1}, Landroid/support/v4/view/ViewCompat$HCViewCompatImpl;->e(Landroid/view/View;)I

    move-result v0

    invoke-virtual {p0, p1, v0, p2}, Landroid/support/v4/view/ViewCompat$HCViewCompatImpl;->a(Landroid/view/View;ILandroid/graphics/Paint;)V

    .line 775
    invoke-virtual {p1}, Landroid/view/View;->invalidate()V

    .line 776
    return-void
.end method

.method public b(Landroid/view/View;F)V
    .locals 0

    .prologue
    .line 835
    invoke-static {p1, p2}, Landroid/support/v4/view/ViewCompatHC;->a(Landroid/view/View;F)V

    .line 836
    return-void
.end method

.method public c(Landroid/view/View;F)V
    .locals 0

    .prologue
    .line 839
    invoke-static {p1, p2}, Landroid/support/v4/view/ViewCompatHC;->b(Landroid/view/View;F)V

    .line 840
    return-void
.end method

.method public d(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 759
    invoke-static {p1}, Landroid/support/v4/view/ViewCompatHC;->a(Landroid/view/View;)F

    move-result v0

    return v0
.end method

.method public e(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 767
    invoke-static {p1}, Landroid/support/v4/view/ViewCompatHC;->b(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public i(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 876
    invoke-static {p1}, Landroid/support/v4/view/ViewCompatHC;->c(Landroid/view/View;)F

    move-result v0

    return v0
.end method
