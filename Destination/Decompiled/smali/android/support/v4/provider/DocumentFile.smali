.class public abstract Landroid/support/v4/provider/DocumentFile;
.super Ljava/lang/Object;
.source "DocumentFile.java"


# instance fields
.field private final a:Landroid/support/v4/provider/DocumentFile;


# direct methods
.method constructor <init>(Landroid/support/v4/provider/DocumentFile;)V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iput-object p1, p0, Landroid/support/v4/provider/DocumentFile;->a:Landroid/support/v4/provider/DocumentFile;

    .line 85
    return-void
.end method

.method public static a(Landroid/content/Context;Landroid/net/Uri;)Landroid/support/v4/provider/DocumentFile;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 128
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 129
    const/16 v2, 0x15

    if-lt v0, v2, :cond_0

    .line 130
    new-instance v0, Landroid/support/v4/provider/TreeDocumentFile;

    invoke-static {p1}, Landroid/support/v4/provider/DocumentsContractApi21;->a(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, p0, v2}, Landroid/support/v4/provider/TreeDocumentFile;-><init>(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V

    .line 133
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method public abstract a()Landroid/net/Uri;
.end method

.method public abstract a(Ljava/lang/String;)Landroid/support/v4/provider/DocumentFile;
.end method

.method public abstract a(Ljava/lang/String;Ljava/lang/String;)Landroid/support/v4/provider/DocumentFile;
.end method

.method public b(Ljava/lang/String;)Landroid/support/v4/provider/DocumentFile;
    .locals 5

    .prologue
    .line 316
    invoke-virtual {p0}, Landroid/support/v4/provider/DocumentFile;->c()[Landroid/support/v4/provider/DocumentFile;

    move-result-object v2

    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 317
    invoke-virtual {v0}, Landroid/support/v4/provider/DocumentFile;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 321
    :goto_1
    return-object v0

    .line 316
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 321
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public abstract b()Ljava/lang/String;
.end method

.method public abstract c()[Landroid/support/v4/provider/DocumentFile;
.end method
