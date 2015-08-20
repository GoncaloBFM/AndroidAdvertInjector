.class public final Landroid/support/v4/app/NotificationCompat$WearableExtender;
.super Ljava/lang/Object;
.source "NotificationCompat.java"

# interfaces
.implements Landroid/support/v4/app/NotificationCompat$Extender;


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v4/app/NotificationCompat$Action;",
            ">;"
        }
    .end annotation
.end field

.field private b:I

.field private c:Landroid/app/PendingIntent;

.field private d:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/app/Notification;",
            ">;"
        }
    .end annotation
.end field

.field private e:Landroid/graphics/Bitmap;

.field private f:I

.field private g:I

.field private h:I

.field private i:I

.field private j:I

.field private k:I

.field private l:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 2319
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2302
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->a:Ljava/util/ArrayList;

    .line 2303
    const/4 v0, 0x1

    iput v0, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->b:I

    .line 2305
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->d:Ljava/util/ArrayList;

    .line 2308
    const v0, 0x800005

    iput v0, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->g:I

    .line 2309
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->h:I

    .line 2310
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->i:I

    .line 2312
    const/16 v0, 0x50

    iput v0, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->k:I

    .line 2320
    return-void
.end method


# virtual methods
.method public a()Landroid/support/v4/app/NotificationCompat$WearableExtender;
    .locals 3

    .prologue
    .line 2412
    new-instance v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;

    invoke-direct {v0}, Landroid/support/v4/app/NotificationCompat$WearableExtender;-><init>()V

    .line 2413
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->a:Ljava/util/ArrayList;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->a:Ljava/util/ArrayList;

    .line 2414
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->b:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->b:I

    .line 2415
    iget-object v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->c:Landroid/app/PendingIntent;

    iput-object v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->c:Landroid/app/PendingIntent;

    .line 2416
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->d:Ljava/util/ArrayList;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->d:Ljava/util/ArrayList;

    .line 2417
    iget-object v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->e:Landroid/graphics/Bitmap;

    iput-object v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->e:Landroid/graphics/Bitmap;

    .line 2418
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->f:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->f:I

    .line 2419
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->g:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->g:I

    .line 2420
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->h:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->h:I

    .line 2421
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->i:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->i:I

    .line 2422
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->j:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->j:I

    .line 2423
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->k:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->k:I

    .line 2424
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->l:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$WearableExtender;->l:I

    .line 2425
    return-object v0
.end method

.method public synthetic clone()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2204
    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$WearableExtender;->a()Landroid/support/v4/app/NotificationCompat$WearableExtender;

    move-result-object v0

    return-object v0
.end method
