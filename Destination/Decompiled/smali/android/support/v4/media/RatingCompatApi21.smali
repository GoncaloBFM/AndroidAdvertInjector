.class Landroid/support/v4/media/RatingCompatApi21;
.super Ljava/lang/Object;
.source "RatingCompatApi21.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 43
    check-cast p0, Landroid/media/Rating;

    invoke-virtual {p0}, Landroid/media/Rating;->isRated()Z

    move-result v0

    return v0
.end method

.method public static b(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 47
    check-cast p0, Landroid/media/Rating;

    invoke-virtual {p0}, Landroid/media/Rating;->getRatingStyle()I

    move-result v0

    return v0
.end method

.method public static c(Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 51
    check-cast p0, Landroid/media/Rating;

    invoke-virtual {p0}, Landroid/media/Rating;->hasHeart()Z

    move-result v0

    return v0
.end method

.method public static d(Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 55
    check-cast p0, Landroid/media/Rating;

    invoke-virtual {p0}, Landroid/media/Rating;->isThumbUp()Z

    move-result v0

    return v0
.end method

.method public static e(Ljava/lang/Object;)F
    .locals 1

    .prologue
    .line 59
    check-cast p0, Landroid/media/Rating;

    invoke-virtual {p0}, Landroid/media/Rating;->getStarRating()F

    move-result v0

    return v0
.end method

.method public static f(Ljava/lang/Object;)F
    .locals 1

    .prologue
    .line 63
    check-cast p0, Landroid/media/Rating;

    invoke-virtual {p0}, Landroid/media/Rating;->getPercentRating()F

    move-result v0

    return v0
.end method
