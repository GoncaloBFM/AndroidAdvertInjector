.class Landroid/support/v4/text/BidiFormatter$DirectionalityEstimator;
.super Ljava/lang/Object;
.source "BidiFormatter.java"


# static fields
.field private static final a:[B


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/16 v3, 0x700

    .line 505
    new-array v0, v3, [B

    sput-object v0, Landroid/support/v4/text/BidiFormatter$DirectionalityEstimator;->a:[B

    .line 506
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_0

    .line 507
    sget-object v1, Landroid/support/v4/text/BidiFormatter$DirectionalityEstimator;->a:[B

    invoke-static {v0}, Ljava/lang/Character;->getDirectionality(I)B

    move-result v2

    aput-byte v2, v1, v0

    .line 506
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 509
    :cond_0
    return-void
.end method
