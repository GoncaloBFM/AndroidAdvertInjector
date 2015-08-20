.class Landroid/support/v4/print/PrintHelperKitkat;
.super Ljava/lang/Object;
.source "PrintHelperKitkat.java"


# instance fields
.field final a:Landroid/content/Context;

.field b:Landroid/graphics/BitmapFactory$Options;

.field private final c:Ljava/lang/Object;


# direct methods
.method private a(Landroid/net/Uri;I)Landroid/graphics/Bitmap;
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 474
    if-lez p2, :cond_0

    if-eqz p1, :cond_0

    iget-object v2, p0, Landroid/support/v4/print/PrintHelperKitkat;->a:Landroid/content/Context;

    if-nez v2, :cond_1

    .line 475
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bad argument to getScaledBitmap"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 478
    :cond_1
    new-instance v2, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v2}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 479
    iput-boolean v1, v2, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 480
    invoke-direct {p0, p1, v2}, Landroid/support/v4/print/PrintHelperKitkat;->a(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 482
    iget v3, v2, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    .line 483
    iget v4, v2, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 486
    if-lez v3, :cond_2

    if-gtz v4, :cond_3

    .line 515
    :cond_2
    :goto_0
    return-object v0

    .line 491
    :cond_3
    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 494
    :goto_1
    if-le v2, p2, :cond_4

    .line 495
    ushr-int/lit8 v2, v2, 0x1

    .line 496
    shl-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 500
    :cond_4
    if-lez v1, :cond_2

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v2

    div-int/2addr v2, v1

    if-lez v2, :cond_2

    .line 504
    iget-object v2, p0, Landroid/support/v4/print/PrintHelperKitkat;->c:Ljava/lang/Object;

    monitor-enter v2

    .line 505
    :try_start_0
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    iput-object v0, p0, Landroid/support/v4/print/PrintHelperKitkat;->b:Landroid/graphics/BitmapFactory$Options;

    .line 506
    iget-object v0, p0, Landroid/support/v4/print/PrintHelperKitkat;->b:Landroid/graphics/BitmapFactory$Options;

    const/4 v3, 0x1

    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 507
    iget-object v0, p0, Landroid/support/v4/print/PrintHelperKitkat;->b:Landroid/graphics/BitmapFactory$Options;

    iput v1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 508
    iget-object v0, p0, Landroid/support/v4/print/PrintHelperKitkat;->b:Landroid/graphics/BitmapFactory$Options;

    .line 509
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 511
    :try_start_1
    invoke-direct {p0, p1, v0}, Landroid/support/v4/print/PrintHelperKitkat;->a(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-result-object v0

    .line 513
    iget-object v1, p0, Landroid/support/v4/print/PrintHelperKitkat;->c:Ljava/lang/Object;

    monitor-enter v1

    .line 514
    const/4 v2, 0x0

    :try_start_2
    iput-object v2, p0, Landroid/support/v4/print/PrintHelperKitkat;->b:Landroid/graphics/BitmapFactory$Options;

    .line 515
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 509
    :catchall_1
    move-exception v0

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0

    .line 513
    :catchall_2
    move-exception v0

    iget-object v1, p0, Landroid/support/v4/print/PrintHelperKitkat;->c:Ljava/lang/Object;

    monitor-enter v1

    .line 514
    const/4 v2, 0x0

    :try_start_4
    iput-object v2, p0, Landroid/support/v4/print/PrintHelperKitkat;->b:Landroid/graphics/BitmapFactory$Options;

    .line 515
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    throw v0

    :catchall_3
    move-exception v0

    :try_start_5
    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    throw v0
.end method

.method private a(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 524
    if-eqz p1, :cond_0

    iget-object v0, p0, Landroid/support/v4/print/PrintHelperKitkat;->a:Landroid/content/Context;

    if-nez v0, :cond_1

    .line 525
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bad argument to loadBitmap"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 529
    :cond_1
    :try_start_0
    iget-object v0, p0, Landroid/support/v4/print/PrintHelperKitkat;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 530
    const/4 v0, 0x0

    invoke-static {v1, v0, p2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 532
    if-eqz v1, :cond_2

    .line 534
    :try_start_1
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 537
    :cond_2
    :goto_0
    return-object v0

    .line 535
    :catch_0
    move-exception v1

    .line 536
    const-string v2, "PrintHelperKitkat"

    const-string v3, "close fail "

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 532
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_3

    .line 534
    :try_start_2
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 537
    :cond_3
    :goto_1
    throw v0

    .line 535
    :catch_1
    move-exception v1

    .line 536
    const-string v2, "PrintHelperKitkat"

    const-string v3, "close fail "

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method

.method static synthetic a(Landroid/support/v4/print/PrintHelperKitkat;Landroid/net/Uri;I)Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Landroid/support/v4/print/PrintHelperKitkat;->a(Landroid/net/Uri;I)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method private a(IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
    .locals 6

    .prologue
    const/high16 v5, 0x40000000    # 2.0f

    .line 270
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    .line 273
    invoke-virtual {p3}, Landroid/graphics/RectF;->width()F

    move-result v0

    int-to-float v2, p1

    div-float/2addr v0, v2

    .line 274
    const/4 v2, 0x2

    if-ne p4, v2, :cond_0

    .line 275
    invoke-virtual {p3}, Landroid/graphics/RectF;->height()F

    move-result v2

    int-to-float v3, p2

    div-float/2addr v2, v3

    invoke-static {v0, v2}, Ljava/lang/Math;->max(FF)F

    move-result v0

    .line 279
    :goto_0
    invoke-virtual {v1, v0, v0}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 282
    invoke-virtual {p3}, Landroid/graphics/RectF;->width()F

    move-result v2

    int-to-float v3, p1

    mul-float/2addr v3, v0

    sub-float/2addr v2, v3

    div-float/2addr v2, v5

    .line 284
    invoke-virtual {p3}, Landroid/graphics/RectF;->height()F

    move-result v3

    int-to-float v4, p2

    mul-float/2addr v0, v4

    sub-float v0, v3, v0

    div-float/2addr v0, v5

    .line 286
    invoke-virtual {v1, v2, v0}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 287
    return-object v1

    .line 277
    :cond_0
    invoke-virtual {p3}, Landroid/graphics/RectF;->height()F

    move-result v2

    int-to-float v3, p2

    div-float/2addr v2, v3

    invoke-static {v0, v2}, Ljava/lang/Math;->min(FF)F

    move-result v0

    goto :goto_0
.end method

.method static synthetic a(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
    .locals 1

    .prologue
    .line 46
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/support/v4/print/PrintHelperKitkat;->a(IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Landroid/support/v4/print/PrintHelperKitkat;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Landroid/support/v4/print/PrintHelperKitkat;->c:Ljava/lang/Object;

    return-object v0
.end method
