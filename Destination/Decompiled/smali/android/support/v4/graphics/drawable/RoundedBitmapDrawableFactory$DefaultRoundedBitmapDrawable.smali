.class Landroid/support/v4/graphics/drawable/RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable;
.super Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;
.source "RoundedBitmapDrawableFactory.java"


# virtual methods
.method a(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)V
    .locals 6

    .prologue
    .line 57
    const/4 v5, 0x0

    move v0, p1

    move v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    invoke-static/range {v0 .. v5}, Landroid/support/v4/view/GravityCompat;->a(IIILandroid/graphics/Rect;Landroid/graphics/Rect;I)V

    .line 59
    return-void
.end method
