.class Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable21;
.super Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;
.source "RoundedBitmapDrawable21.java"


# virtual methods
.method a(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)V
    .locals 6

    .prologue
    .line 53
    const/4 v5, 0x0

    move v0, p1

    move v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    invoke-static/range {v0 .. v5}, Landroid/view/Gravity;->apply(IIILandroid/graphics/Rect;Landroid/graphics/Rect;I)V

    .line 55
    return-void
.end method

.method public getOutline(Landroid/graphics/Outline;)V
    .locals 2

    .prologue
    .line 33
    invoke-virtual {p0}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable21;->a()V

    .line 34
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable21;->b:Landroid/graphics/Rect;

    invoke-virtual {p0}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable21;->b()F

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Outline;->setRoundRect(Landroid/graphics/Rect;F)V

    .line 35
    return-void
.end method
