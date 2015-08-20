.class public abstract Landroid/support/v4/widget/ExploreByTouchHelper;
.super Landroid/support/v4/view/AccessibilityDelegateCompat;
.source "ExploreByTouchHelper.java"


# static fields
.field private static final b:Ljava/lang/String;


# instance fields
.field private final c:Landroid/graphics/Rect;

.field private final d:Landroid/graphics/Rect;

.field private final e:Landroid/graphics/Rect;

.field private final f:[I

.field private final g:Landroid/view/accessibility/AccessibilityManager;

.field private final h:Landroid/view/View;

.field private i:Landroid/support/v4/widget/ExploreByTouchHelper$ExploreByTouchNodeProvider;

.field private j:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 61
    const-class v0, Landroid/view/View;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroid/support/v4/widget/ExploreByTouchHelper;->b:Ljava/lang/String;

    return-void
.end method

.method static synthetic a(Landroid/support/v4/widget/ExploreByTouchHelper;I)Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0, p1}, Landroid/support/v4/widget/ExploreByTouchHelper;->b(I)Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;

    move-result-object v0

    return-object v0
.end method

.method private a(I)Landroid/view/accessibility/AccessibilityEvent;
    .locals 2

    .prologue
    .line 271
    invoke-static {p1}, Landroid/view/accessibility/AccessibilityEvent;->obtain(I)Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    .line 272
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-static {v1, v0}, Landroid/support/v4/view/ViewCompat;->a(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    .line 273
    return-object v0
.end method

.method private a(ILandroid/os/Bundle;)Z
    .locals 1

    .prologue
    .line 450
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-static {v0, p1, p2}, Landroid/support/v4/view/ViewCompat;->a(Landroid/view/View;ILandroid/os/Bundle;)Z

    move-result v0

    return v0
.end method

.method private a(Landroid/graphics/Rect;)Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 484
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v1

    .line 514
    :goto_0
    return v0

    .line 489
    :cond_1
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getWindowVisibility()I

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    .line 490
    goto :goto_0

    .line 494
    :cond_2
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 495
    :goto_1
    instance-of v2, v0, Landroid/view/View;

    if-eqz v2, :cond_5

    .line 496
    check-cast v0, Landroid/view/View;

    .line 497
    invoke-static {v0}, Landroid/support/v4/view/ViewCompat;->d(Landroid/view/View;)F

    move-result v2

    const/4 v3, 0x0

    cmpg-float v2, v2, v3

    if-lez v2, :cond_3

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-eqz v2, :cond_4

    :cond_3
    move v0, v1

    .line 498
    goto :goto_0

    .line 500
    :cond_4
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    goto :goto_1

    .line 504
    :cond_5
    if-nez v0, :cond_6

    move v0, v1

    .line 505
    goto :goto_0

    .line 509
    :cond_6
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    iget-object v2, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->e:Landroid/graphics/Rect;

    invoke-virtual {v0, v2}, Landroid/view/View;->getLocalVisibleRect(Landroid/graphics/Rect;)Z

    move-result v0

    if-nez v0, :cond_7

    move v0, v1

    .line 510
    goto :goto_0

    .line 514
    :cond_7
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->e:Landroid/graphics/Rect;

    invoke-virtual {p1, v0}, Landroid/graphics/Rect;->intersect(Landroid/graphics/Rect;)Z

    move-result v0

    goto :goto_0
.end method

.method static synthetic a(Landroid/support/v4/widget/ExploreByTouchHelper;IILandroid/os/Bundle;)Z
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v4/widget/ExploreByTouchHelper;->b(IILandroid/os/Bundle;)Z

    move-result v0

    return v0
.end method

.method private b()Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;
    .locals 4

    .prologue
    .line 335
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-static {v0}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->a(Landroid/view/View;)Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;

    move-result-object v1

    .line 336
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-static {v0, v1}, Landroid/support/v4/view/ViewCompat;->a(Landroid/view/View;Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;)V

    .line 339
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 340
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(Ljava/util/List;)V

    .line 342
    invoke-virtual {v0}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 343
    iget-object v3, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v1, v3, v0}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->b(Landroid/view/View;I)V

    goto :goto_0

    .line 346
    :cond_0
    return-object v1
.end method

.method private b(I)Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;
    .locals 1

    .prologue
    .line 320
    packed-switch p1, :pswitch_data_0

    .line 324
    invoke-direct {p0, p1}, Landroid/support/v4/widget/ExploreByTouchHelper;->c(I)Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;

    move-result-object v0

    :goto_0
    return-object v0

    .line 322
    :pswitch_0
    invoke-direct {p0}, Landroid/support/v4/widget/ExploreByTouchHelper;->b()Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;

    move-result-object v0

    goto :goto_0

    .line 320
    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
    .end packed-switch
.end method

.method private b(II)Landroid/view/accessibility/AccessibilityEvent;
    .locals 1

    .prologue
    .line 255
    packed-switch p1, :pswitch_data_0

    .line 259
    invoke-direct {p0, p1, p2}, Landroid/support/v4/widget/ExploreByTouchHelper;->c(II)Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    :goto_0
    return-object v0

    .line 257
    :pswitch_0
    invoke-direct {p0, p2}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(I)Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    goto :goto_0

    .line 255
    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
    .end packed-switch
.end method

.method private b(IILandroid/os/Bundle;)Z
    .locals 1

    .prologue
    .line 441
    packed-switch p1, :pswitch_data_0

    .line 445
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v4/widget/ExploreByTouchHelper;->c(IILandroid/os/Bundle;)Z

    move-result v0

    :goto_0
    return v0

    .line 443
    :pswitch_0
    invoke-direct {p0, p2, p3}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(ILandroid/os/Bundle;)Z

    move-result v0

    goto :goto_0

    .line 441
    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
    .end packed-switch
.end method

.method private c(I)Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 378
    invoke-static {}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->b()Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;

    move-result-object v0

    .line 381
    invoke-virtual {v0, v3}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->h(Z)V

    .line 382
    sget-object v1, Landroid/support/v4/widget/ExploreByTouchHelper;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->b(Ljava/lang/CharSequence;)V

    .line 385
    invoke-virtual {p0, p1, v0}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(ILandroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;)V

    .line 388
    invoke-virtual {v0}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->s()Ljava/lang/CharSequence;

    move-result-object v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->t()Ljava/lang/CharSequence;

    move-result-object v1

    if-nez v1, :cond_0

    .line 389
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Callbacks must add text or a content description in populateNodeForVirtualViewId()"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 393
    :cond_0
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->d:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->a(Landroid/graphics/Rect;)V

    .line 394
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->d:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 395
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Callbacks must set parent bounds in populateNodeForVirtualViewId()"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 399
    :cond_1
    invoke-virtual {v0}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->c()I

    move-result v1

    .line 400
    and-int/lit8 v2, v1, 0x40

    if-eqz v2, :cond_2

    .line 401
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 404
    :cond_2
    and-int/lit16 v1, v1, 0x80

    if-eqz v1, :cond_3

    .line 405
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 410
    :cond_3
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->a(Ljava/lang/CharSequence;)V

    .line 411
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v0, v1, p1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->a(Landroid/view/View;I)V

    .line 412
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->d(Landroid/view/View;)V

    .line 415
    iget v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->j:I

    if-ne v1, p1, :cond_5

    .line 416
    invoke-virtual {v0, v3}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->d(Z)V

    .line 417
    const/16 v1, 0x80

    invoke-virtual {v0, v1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->a(I)V

    .line 424
    :goto_0
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->d:Landroid/graphics/Rect;

    invoke-direct {p0, v1}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(Landroid/graphics/Rect;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 425
    invoke-virtual {v0, v3}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->c(Z)V

    .line 426
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->d:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->b(Landroid/graphics/Rect;)V

    .line 430
    :cond_4
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    iget-object v2, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->f:[I

    invoke-virtual {v1, v2}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 431
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->f:[I

    aget v1, v1, v4

    .line 432
    iget-object v2, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->f:[I

    aget v2, v2, v3

    .line 433
    iget-object v3, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->c:Landroid/graphics/Rect;

    iget-object v4, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->d:Landroid/graphics/Rect;

    invoke-virtual {v3, v4}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 434
    iget-object v3, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->c:Landroid/graphics/Rect;

    invoke-virtual {v3, v1, v2}, Landroid/graphics/Rect;->offset(II)V

    .line 435
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->c:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->d(Landroid/graphics/Rect;)V

    .line 437
    return-object v0

    .line 419
    :cond_5
    invoke-virtual {v0, v4}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->d(Z)V

    .line 420
    const/16 v1, 0x40

    invoke-virtual {v0, v1}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->a(I)V

    goto :goto_0
.end method

.method private c(II)Landroid/view/accessibility/AccessibilityEvent;
    .locals 3

    .prologue
    .line 287
    invoke-static {p2}, Landroid/view/accessibility/AccessibilityEvent;->obtain(I)Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    .line 288
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/accessibility/AccessibilityEvent;->setEnabled(Z)V

    .line 289
    sget-object v1, Landroid/support/v4/widget/ExploreByTouchHelper;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 292
    invoke-virtual {p0, p1, v0}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(ILandroid/view/accessibility/AccessibilityEvent;)V

    .line 295
    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityEvent;->getText()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityEvent;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v1

    if-nez v1, :cond_0

    .line 296
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Callbacks must add text or a content description in populateEventForVirtualViewId()"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 301
    :cond_0
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/accessibility/AccessibilityEvent;->setPackageName(Ljava/lang/CharSequence;)V

    .line 303
    invoke-static {v0}, Landroid/support/v4/view/accessibility/AccessibilityEventCompat;->a(Landroid/view/accessibility/AccessibilityEvent;)Landroid/support/v4/view/accessibility/AccessibilityRecordCompat;

    move-result-object v1

    .line 304
    iget-object v2, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v1, v2, p1}, Landroid/support/v4/view/accessibility/AccessibilityRecordCompat;->a(Landroid/view/View;I)V

    .line 306
    return-object v0
.end method

.method private c(IILandroid/os/Bundle;)Z
    .locals 1

    .prologue
    .line 454
    sparse-switch p2, :sswitch_data_0

    .line 459
    invoke-virtual {p0, p1, p2, p3}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(IILandroid/os/Bundle;)Z

    move-result v0

    :goto_0
    return v0

    .line 457
    :sswitch_0
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v4/widget/ExploreByTouchHelper;->d(IILandroid/os/Bundle;)Z

    move-result v0

    goto :goto_0

    .line 454
    nop

    :sswitch_data_0
    .sparse-switch
        0x40 -> :sswitch_0
        0x80 -> :sswitch_0
    .end sparse-switch
.end method

.method private d(I)Z
    .locals 1

    .prologue
    .line 523
    iget v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->j:I

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private d(IILandroid/os/Bundle;)Z
    .locals 1

    .prologue
    .line 464
    sparse-switch p2, :sswitch_data_0

    .line 470
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 466
    :sswitch_0
    invoke-direct {p0, p1}, Landroid/support/v4/widget/ExploreByTouchHelper;->e(I)Z

    move-result v0

    goto :goto_0

    .line 468
    :sswitch_1
    invoke-direct {p0, p1}, Landroid/support/v4/widget/ExploreByTouchHelper;->f(I)Z

    move-result v0

    goto :goto_0

    .line 464
    nop

    :sswitch_data_0
    .sparse-switch
        0x40 -> :sswitch_0
        0x80 -> :sswitch_1
    .end sparse-switch
.end method

.method private e(I)Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 539
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->g:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->g:Landroid/view/accessibility/AccessibilityManager;

    invoke-static {v1}, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a(Landroid/view/accessibility/AccessibilityManager;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 552
    :cond_0
    :goto_0
    return v0

    .line 544
    :cond_1
    invoke-direct {p0, p1}, Landroid/support/v4/widget/ExploreByTouchHelper;->d(I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 545
    iput p1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->j:I

    .line 547
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 548
    const v0, 0x8000

    invoke-virtual {p0, p1, v0}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(II)Z

    .line 550
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private f(I)Z
    .locals 1

    .prologue
    .line 563
    invoke-direct {p0, p1}, Landroid/support/v4/widget/ExploreByTouchHelper;->d(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 564
    const/high16 v0, -0x80000000

    iput v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->j:I

    .line 565
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 566
    const/high16 v0, 0x10000

    invoke-virtual {p0, p1, v0}, Landroid/support/v4/widget/ExploreByTouchHelper;->a(II)Z

    .line 568
    const/4 v0, 0x1

    .line 570
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a(Landroid/view/View;)Landroid/support/v4/view/accessibility/AccessibilityNodeProviderCompat;
    .locals 2

    .prologue
    .line 107
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->i:Landroid/support/v4/widget/ExploreByTouchHelper$ExploreByTouchNodeProvider;

    if-nez v0, :cond_0

    .line 108
    new-instance v0, Landroid/support/v4/widget/ExploreByTouchHelper$ExploreByTouchNodeProvider;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/support/v4/widget/ExploreByTouchHelper$ExploreByTouchNodeProvider;-><init>(Landroid/support/v4/widget/ExploreByTouchHelper;Landroid/support/v4/widget/ExploreByTouchHelper$1;)V

    iput-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->i:Landroid/support/v4/widget/ExploreByTouchHelper$ExploreByTouchNodeProvider;

    .line 110
    :cond_0
    iget-object v0, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->i:Landroid/support/v4/widget/ExploreByTouchHelper$ExploreByTouchNodeProvider;

    return-object v0
.end method

.method protected abstract a(ILandroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;)V
.end method

.method protected abstract a(ILandroid/view/accessibility/AccessibilityEvent;)V
.end method

.method protected abstract a(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation
.end method

.method public a(II)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 173
    const/high16 v1, -0x80000000

    if-eq p1, v1, :cond_0

    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->g:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v1

    if-nez v1, :cond_1

    .line 183
    :cond_0
    :goto_0
    return v0

    .line 177
    :cond_1
    iget-object v1, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    .line 178
    if-eqz v1, :cond_0

    .line 182
    invoke-direct {p0, p1, p2}, Landroid/support/v4/widget/ExploreByTouchHelper;->b(II)Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    .line 183
    iget-object v2, p0, Landroid/support/v4/widget/ExploreByTouchHelper;->h:Landroid/view/View;

    invoke-static {v1, v2, v0}, Landroid/support/v4/view/ViewParentCompat;->a(Landroid/view/ViewParent;Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected abstract a(IILandroid/os/Bundle;)Z
.end method
