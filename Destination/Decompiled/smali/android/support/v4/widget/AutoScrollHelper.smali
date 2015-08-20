.class public abstract Landroid/support/v4/widget/AutoScrollHelper;
.super Ljava/lang/Object;
.source "AutoScrollHelper.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# static fields
.field private static final r:I


# instance fields
.field private final a:Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;

.field private final b:Landroid/view/animation/Interpolator;

.field private final c:Landroid/view/View;

.field private d:Ljava/lang/Runnable;

.field private e:[F

.field private f:[F

.field private g:I

.field private h:I

.field private i:[F

.field private j:[F

.field private k:[F

.field private l:Z

.field private m:Z

.field private n:Z

.field private o:Z

.field private p:Z

.field private q:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 194
    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v0

    sput v0, Landroid/support/v4/widget/AutoScrollHelper;->r:I

    return-void
.end method

.method private a(FF)F
    .locals 4

    .prologue
    const/high16 v1, 0x3f800000    # 1.0f

    const/4 v0, 0x0

    .line 624
    cmpl-float v2, p2, v0

    if-nez v2, :cond_1

    .line 649
    :cond_0
    :goto_0
    return v0

    .line 628
    :cond_1
    iget v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->g:I

    packed-switch v2, :pswitch_data_0

    goto :goto_0

    .line 631
    :pswitch_0
    cmpg-float v2, p1, p2

    if-gez v2, :cond_0

    .line 632
    cmpl-float v2, p1, v0

    if-ltz v2, :cond_2

    .line 634
    div-float v0, p1, p2

    sub-float v0, v1, v0

    goto :goto_0

    .line 635
    :cond_2
    iget-boolean v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->o:Z

    if-eqz v2, :cond_0

    iget v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->g:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    move v0, v1

    .line 637
    goto :goto_0

    .line 642
    :pswitch_1
    cmpg-float v1, p1, v0

    if-gez v1, :cond_0

    .line 644
    neg-float v0, p2

    div-float v0, p1, v0

    goto :goto_0

    .line 628
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method static synthetic a(FFF)F
    .locals 1

    .prologue
    .line 84
    invoke-static {p0, p1, p2}, Landroid/support/v4/widget/AutoScrollHelper;->b(FFF)F

    move-result v0

    return v0
.end method

.method private a(FFFF)F
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 607
    mul-float v1, p1, p2

    invoke-static {v1, v0, p3}, Landroid/support/v4/widget/AutoScrollHelper;->b(FFF)F

    move-result v1

    .line 608
    invoke-direct {p0, p4, v1}, Landroid/support/v4/widget/AutoScrollHelper;->a(FF)F

    move-result v2

    .line 609
    sub-float v3, p2, p4

    invoke-direct {p0, v3, v1}, Landroid/support/v4/widget/AutoScrollHelper;->a(FF)F

    move-result v1

    .line 610
    sub-float/2addr v1, v2

    .line 612
    cmpg-float v2, v1, v0

    if-gez v2, :cond_1

    .line 613
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->b:Landroid/view/animation/Interpolator;

    neg-float v1, v1

    invoke-interface {v0, v1}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v0

    neg-float v0, v0

    .line 620
    :goto_0
    const/high16 v1, -0x40800000    # -1.0f

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-static {v0, v1, v2}, Landroid/support/v4/widget/AutoScrollHelper;->b(FFF)F

    move-result v0

    :cond_0
    return v0

    .line 614
    :cond_1
    cmpl-float v2, v1, v0

    if-lez v2, :cond_0

    .line 615
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->b:Landroid/view/animation/Interpolator;

    invoke-interface {v0, v1}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v0

    goto :goto_0
.end method

.method private a(IFFF)F
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 539
    iget-object v1, p0, Landroid/support/v4/widget/AutoScrollHelper;->e:[F

    aget v1, v1, p1

    .line 540
    iget-object v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->f:[F

    aget v2, v2, p1

    .line 541
    invoke-direct {p0, v1, p3, v2, p2}, Landroid/support/v4/widget/AutoScrollHelper;->a(FFFF)F

    move-result v1

    .line 542
    cmpl-float v2, v1, v0

    if-nez v2, :cond_0

    .line 558
    :goto_0
    return v0

    .line 547
    :cond_0
    iget-object v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->i:[F

    aget v2, v2, p1

    .line 548
    iget-object v3, p0, Landroid/support/v4/widget/AutoScrollHelper;->j:[F

    aget v3, v3, p1

    .line 549
    iget-object v4, p0, Landroid/support/v4/widget/AutoScrollHelper;->k:[F

    aget v4, v4, p1

    .line 550
    mul-float/2addr v2, p4

    .line 555
    cmpl-float v0, v1, v0

    if-lez v0, :cond_1

    .line 556
    mul-float v0, v1, v2

    invoke-static {v0, v3, v4}, Landroid/support/v4/widget/AutoScrollHelper;->b(FFF)F

    move-result v0

    goto :goto_0

    .line 558
    :cond_1
    neg-float v0, v1

    mul-float/2addr v0, v2

    invoke-static {v0, v3, v4}, Landroid/support/v4/widget/AutoScrollHelper;->b(FFF)F

    move-result v0

    neg-float v0, v0

    goto :goto_0
.end method

.method static synthetic a(III)I
    .locals 1

    .prologue
    .line 84
    invoke-static {p0, p1, p2}, Landroid/support/v4/widget/AutoScrollHelper;->b(III)I

    move-result v0

    return v0
.end method

.method private a()Z
    .locals 2

    .prologue
    .line 492
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->a:Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;

    .line 493
    invoke-virtual {v0}, Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;->f()I

    move-result v1

    .line 494
    invoke-virtual {v0}, Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;->e()I

    move-result v0

    .line 496
    if-eqz v1, :cond_0

    invoke-virtual {p0, v1}, Landroid/support/v4/widget/AutoScrollHelper;->b(I)Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    if-eqz v0, :cond_2

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/AutoScrollHelper;->a(I)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic a(Landroid/support/v4/widget/AutoScrollHelper;)Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->o:Z

    return v0
.end method

.method static synthetic a(Landroid/support/v4/widget/AutoScrollHelper;Z)Z
    .locals 0

    .prologue
    .line 84
    iput-boolean p1, p0, Landroid/support/v4/widget/AutoScrollHelper;->m:Z

    return p1
.end method

.method private static b(FFF)F
    .locals 1

    .prologue
    .line 663
    cmpl-float v0, p0, p2

    if-lez v0, :cond_0

    .line 668
    :goto_0
    return p2

    .line 665
    :cond_0
    cmpg-float v0, p0, p1

    if-gez v0, :cond_1

    move p2, p1

    .line 666
    goto :goto_0

    :cond_1
    move p2, p0

    .line 668
    goto :goto_0
.end method

.method private static b(III)I
    .locals 0

    .prologue
    .line 653
    if-le p0, p2, :cond_0

    .line 658
    :goto_0
    return p2

    .line 655
    :cond_0
    if-ge p0, p1, :cond_1

    move p2, p1

    .line 656
    goto :goto_0

    :cond_1
    move p2, p0

    .line 658
    goto :goto_0
.end method

.method private b()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 504
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->d:Ljava/lang/Runnable;

    if-nez v0, :cond_0

    .line 505
    new-instance v0, Landroid/support/v4/widget/AutoScrollHelper$ScrollAnimationRunnable;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/support/v4/widget/AutoScrollHelper$ScrollAnimationRunnable;-><init>(Landroid/support/v4/widget/AutoScrollHelper;Landroid/support/v4/widget/AutoScrollHelper$1;)V

    iput-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->d:Ljava/lang/Runnable;

    .line 508
    :cond_0
    iput-boolean v4, p0, Landroid/support/v4/widget/AutoScrollHelper;->o:Z

    .line 509
    iput-boolean v4, p0, Landroid/support/v4/widget/AutoScrollHelper;->m:Z

    .line 511
    iget-boolean v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->l:Z

    if-nez v0, :cond_1

    iget v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->h:I

    if-lez v0, :cond_1

    .line 512
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->c:Landroid/view/View;

    iget-object v1, p0, Landroid/support/v4/widget/AutoScrollHelper;->d:Ljava/lang/Runnable;

    iget v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->h:I

    int-to-long v2, v2

    invoke-static {v0, v1, v2, v3}, Landroid/support/v4/view/ViewCompat;->a(Landroid/view/View;Ljava/lang/Runnable;J)V

    .line 519
    :goto_0
    iput-boolean v4, p0, Landroid/support/v4/widget/AutoScrollHelper;->l:Z

    .line 520
    return-void

    .line 514
    :cond_1
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->d:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    goto :goto_0
.end method

.method static synthetic b(Landroid/support/v4/widget/AutoScrollHelper;)Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->m:Z

    return v0
.end method

.method static synthetic b(Landroid/support/v4/widget/AutoScrollHelper;Z)Z
    .locals 0

    .prologue
    .line 84
    iput-boolean p1, p0, Landroid/support/v4/widget/AutoScrollHelper;->o:Z

    return p1
.end method

.method static synthetic c(Landroid/support/v4/widget/AutoScrollHelper;)Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->a:Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;

    return-object v0
.end method

.method private c()V
    .locals 1

    .prologue
    .line 528
    iget-boolean v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->m:Z

    if-eqz v0, :cond_0

    .line 531
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->o:Z

    .line 535
    :goto_0
    return-void

    .line 533
    :cond_0
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->a:Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;

    invoke-virtual {v0}, Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;->b()V

    goto :goto_0
.end method

.method static synthetic c(Landroid/support/v4/widget/AutoScrollHelper;Z)Z
    .locals 0

    .prologue
    .line 84
    iput-boolean p1, p0, Landroid/support/v4/widget/AutoScrollHelper;->n:Z

    return p1
.end method

.method private d()V
    .locals 8

    .prologue
    const/4 v5, 0x0

    .line 677
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .line 678
    const/4 v4, 0x3

    const/4 v7, 0x0

    move-wide v2, v0

    move v6, v5

    invoke-static/range {v0 .. v7}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v0

    .line 680
    iget-object v1, p0, Landroid/support/v4/widget/AutoScrollHelper;->c:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 681
    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    .line 682
    return-void
.end method

.method static synthetic d(Landroid/support/v4/widget/AutoScrollHelper;)Z
    .locals 1

    .prologue
    .line 84
    invoke-direct {p0}, Landroid/support/v4/widget/AutoScrollHelper;->a()Z

    move-result v0

    return v0
.end method

.method static synthetic e(Landroid/support/v4/widget/AutoScrollHelper;)Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->n:Z

    return v0
.end method

.method static synthetic f(Landroid/support/v4/widget/AutoScrollHelper;)V
    .locals 0

    .prologue
    .line 84
    invoke-direct {p0}, Landroid/support/v4/widget/AutoScrollHelper;->d()V

    return-void
.end method

.method static synthetic g(Landroid/support/v4/widget/AutoScrollHelper;)Landroid/view/View;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->c:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public abstract a(II)V
.end method

.method public abstract a(I)Z
.end method

.method public abstract b(I)Z
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 6

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 456
    iget-boolean v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->p:Z

    if-nez v2, :cond_0

    .line 485
    :goto_0
    return v1

    .line 460
    :cond_0
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->a(Landroid/view/MotionEvent;)I

    move-result v2

    .line 461
    packed-switch v2, :pswitch_data_0

    .line 485
    :cond_1
    :goto_1
    iget-boolean v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->q:Z

    if-eqz v2, :cond_2

    iget-boolean v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->o:Z

    if-eqz v2, :cond_2

    :goto_2
    move v1, v0

    goto :goto_0

    .line 463
    :pswitch_0
    iput-boolean v0, p0, Landroid/support/v4/widget/AutoScrollHelper;->n:Z

    .line 464
    iput-boolean v1, p0, Landroid/support/v4/widget/AutoScrollHelper;->l:Z

    .line 467
    :pswitch_1
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Landroid/support/v4/widget/AutoScrollHelper;->c:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v4

    int-to-float v4, v4

    invoke-direct {p0, v1, v2, v3, v4}, Landroid/support/v4/widget/AutoScrollHelper;->a(IFFF)F

    move-result v2

    .line 469
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Landroid/support/v4/widget/AutoScrollHelper;->c:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v5

    int-to-float v5, v5

    invoke-direct {p0, v0, v3, v4, v5}, Landroid/support/v4/widget/AutoScrollHelper;->a(IFFF)F

    move-result v3

    .line 471
    iget-object v4, p0, Landroid/support/v4/widget/AutoScrollHelper;->a:Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;

    invoke-virtual {v4, v2, v3}, Landroid/support/v4/widget/AutoScrollHelper$ClampedScroller;->a(FF)V

    .line 475
    iget-boolean v2, p0, Landroid/support/v4/widget/AutoScrollHelper;->o:Z

    if-nez v2, :cond_1

    invoke-direct {p0}, Landroid/support/v4/widget/AutoScrollHelper;->a()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 476
    invoke-direct {p0}, Landroid/support/v4/widget/AutoScrollHelper;->b()V

    goto :goto_1

    .line 481
    :pswitch_2
    invoke-direct {p0}, Landroid/support/v4/widget/AutoScrollHelper;->c()V

    goto :goto_1

    :cond_2
    move v0, v1

    .line 485
    goto :goto_2

    .line 461
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
