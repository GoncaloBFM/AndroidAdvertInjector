.class public abstract Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "RoundedBitmapDrawable.java"


# instance fields
.field a:Landroid/graphics/Bitmap;

.field final b:Landroid/graphics/Rect;

.field final c:Landroid/graphics/RectF;

.field private d:I

.field private e:Landroid/graphics/Paint;

.field private f:F

.field private g:Z

.field private h:I

.field private i:I


# direct methods
.method private static a(F)Z
    .locals 1

    .prologue
    .line 325
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ljava/lang/Float;->compare(FF)I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method a()V
    .locals 6

    .prologue
    .line 219
    iget-boolean v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->g:Z

    if-eqz v0, :cond_0

    .line 220
    iget v1, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->d:I

    iget v2, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->h:I

    iget v3, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->i:I

    invoke-virtual {p0}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v4

    iget-object v5, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->b:Landroid/graphics/Rect;

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->a(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)V

    .line 222
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->c:Landroid/graphics/RectF;

    iget-object v1, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->b:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    .line 223
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->g:Z

    .line 225
    :cond_0
    return-void
.end method

.method a(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)V
    .locals 1

    .prologue
    .line 215
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public b()F
    .locals 1

    .prologue
    .line 284
    iget v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->f:F

    return v0
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 4

    .prologue
    .line 229
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->a:Landroid/graphics/Bitmap;

    .line 230
    if-nez v0, :cond_0

    .line 243
    :goto_0
    return-void

    .line 234
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->a()V

    .line 236
    iget-object v1, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    .line 237
    invoke-virtual {v1}, Landroid/graphics/Paint;->getShader()Landroid/graphics/Shader;

    move-result-object v2

    .line 238
    if-nez v2, :cond_1

    .line 239
    const/4 v2, 0x0

    iget-object v3, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->b:Landroid/graphics/Rect;

    invoke-virtual {p1, v0, v2, v3, v1}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    goto :goto_0

    .line 241
    :cond_1
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->c:Landroid/graphics/RectF;

    iget v2, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->f:F

    iget v3, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->f:F

    invoke-virtual {p1, v0, v2, v3, v1}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    goto :goto_0
.end method

.method public getAlpha()I
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    return v0
.end method

.method public getColorFilter()Landroid/graphics/ColorFilter;
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getColorFilter()Landroid/graphics/ColorFilter;

    move-result-object v0

    return-object v0
.end method

.method public getIntrinsicHeight()I
    .locals 1

    .prologue
    .line 294
    iget v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->i:I

    return v0
.end method

.method public getIntrinsicWidth()I
    .locals 1

    .prologue
    .line 289
    iget v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->h:I

    return v0
.end method

.method public getOpacity()I
    .locals 3

    .prologue
    const/4 v0, -0x3

    .line 299
    iget v1, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->d:I

    const/16 v2, 0x77

    if-eq v1, v2, :cond_1

    .line 303
    :cond_0
    :goto_0
    return v0

    .line 302
    :cond_1
    iget-object v1, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->a:Landroid/graphics/Bitmap;

    .line 303
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->hasAlpha()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    invoke-virtual {v1}, Landroid/graphics/Paint;->getAlpha()I

    move-result v1

    const/16 v2, 0xff

    if-lt v1, v2, :cond_0

    iget v1, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->f:F

    invoke-static {v1}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->a(F)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, -0x1

    goto :goto_0
.end method

.method public setAlpha(I)V
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    .line 248
    if-eq p1, v0, :cond_0

    .line 249
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 250
    invoke-virtual {p0}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->invalidateSelf()V

    .line 252
    :cond_0
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 261
    invoke-virtual {p0}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->invalidateSelf()V

    .line 262
    return-void
.end method

.method public setDither(Z)V
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setDither(Z)V

    .line 210
    invoke-virtual {p0}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->invalidateSelf()V

    .line 211
    return-void
.end method

.method public setFilterBitmap(Z)V
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->e:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 204
    invoke-virtual {p0}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->invalidateSelf()V

    .line 205
    return-void
.end method
