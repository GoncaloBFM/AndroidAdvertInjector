.class public final Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;
.super Ljava/lang/Object;
.source "NotificationCompat.java"

# interfaces
.implements Landroid/support/v4/app/NotificationCompat$Action$Extender;


# instance fields
.field private a:I

.field private b:Ljava/lang/CharSequence;

.field private c:Ljava/lang/CharSequence;

.field private d:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 1984
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1974
    const/4 v0, 0x1

    iput v0, p0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->a:I

    .line 1985
    return-void
.end method


# virtual methods
.method public a()Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;
    .locals 2

    .prologue
    .line 2030
    new-instance v0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;

    invoke-direct {v0}, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;-><init>()V

    .line 2031
    iget v1, p0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->a:I

    iput v1, v0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->a:I

    .line 2032
    iget-object v1, p0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->b:Ljava/lang/CharSequence;

    iput-object v1, v0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->b:Ljava/lang/CharSequence;

    .line 2033
    iget-object v1, p0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->c:Ljava/lang/CharSequence;

    iput-object v1, v0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->c:Ljava/lang/CharSequence;

    .line 2034
    iget-object v1, p0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->d:Ljava/lang/CharSequence;

    iput-object v1, v0, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->d:Ljava/lang/CharSequence;

    .line 2035
    return-object v0
.end method

.method public synthetic clone()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1958
    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;->a()Landroid/support/v4/app/NotificationCompat$Action$WearableExtender;

    move-result-object v0

    return-object v0
.end method
