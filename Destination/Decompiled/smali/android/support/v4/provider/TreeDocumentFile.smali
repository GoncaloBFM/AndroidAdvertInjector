.class Landroid/support/v4/provider/TreeDocumentFile;
.super Landroid/support/v4/provider/DocumentFile;
.source "TreeDocumentFile.java"


# instance fields
.field private a:Landroid/content/Context;

.field private b:Landroid/net/Uri;


# direct methods
.method constructor <init>(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/support/v4/provider/DocumentFile;-><init>(Landroid/support/v4/provider/DocumentFile;)V

    .line 28
    iput-object p2, p0, Landroid/support/v4/provider/TreeDocumentFile;->a:Landroid/content/Context;

    .line 29
    iput-object p3, p0, Landroid/support/v4/provider/TreeDocumentFile;->b:Landroid/net/Uri;

    .line 30
    return-void
.end method


# virtual methods
.method public a()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Landroid/support/v4/provider/TreeDocumentFile;->b:Landroid/net/Uri;

    return-object v0
.end method

.method public a(Ljava/lang/String;)Landroid/support/v4/provider/DocumentFile;
    .locals 3

    .prologue
    .line 40
    iget-object v0, p0, Landroid/support/v4/provider/TreeDocumentFile;->a:Landroid/content/Context;

    iget-object v1, p0, Landroid/support/v4/provider/TreeDocumentFile;->b:Landroid/net/Uri;

    invoke-static {v0, v1, p1}, Landroid/support/v4/provider/DocumentsContractApi21;->a(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 41
    if-eqz v1, :cond_0

    new-instance v0, Landroid/support/v4/provider/TreeDocumentFile;

    iget-object v2, p0, Landroid/support/v4/provider/TreeDocumentFile;->a:Landroid/content/Context;

    invoke-direct {v0, p0, v2, v1}, Landroid/support/v4/provider/TreeDocumentFile;-><init>(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)Landroid/support/v4/provider/DocumentFile;
    .locals 3

    .prologue
    .line 34
    iget-object v0, p0, Landroid/support/v4/provider/TreeDocumentFile;->a:Landroid/content/Context;

    iget-object v1, p0, Landroid/support/v4/provider/TreeDocumentFile;->b:Landroid/net/Uri;

    invoke-static {v0, v1, p1, p2}, Landroid/support/v4/provider/DocumentsContractApi21;->a(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 35
    if-eqz v1, :cond_0

    new-instance v0, Landroid/support/v4/provider/TreeDocumentFile;

    iget-object v2, p0, Landroid/support/v4/provider/TreeDocumentFile;->a:Landroid/content/Context;

    invoke-direct {v0, p0, v2, v1}, Landroid/support/v4/provider/TreeDocumentFile;-><init>(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b()Ljava/lang/String;
    .locals 2

    .prologue
    .line 51
    iget-object v0, p0, Landroid/support/v4/provider/TreeDocumentFile;->a:Landroid/content/Context;

    iget-object v1, p0, Landroid/support/v4/provider/TreeDocumentFile;->b:Landroid/net/Uri;

    invoke-static {v0, v1}, Landroid/support/v4/provider/DocumentsContractApi19;->a(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public c()[Landroid/support/v4/provider/DocumentFile;
    .locals 6

    .prologue
    .line 101
    iget-object v0, p0, Landroid/support/v4/provider/TreeDocumentFile;->a:Landroid/content/Context;

    iget-object v1, p0, Landroid/support/v4/provider/TreeDocumentFile;->b:Landroid/net/Uri;

    invoke-static {v0, v1}, Landroid/support/v4/provider/DocumentsContractApi21;->a(Landroid/content/Context;Landroid/net/Uri;)[Landroid/net/Uri;

    move-result-object v1

    .line 102
    array-length v0, v1

    new-array v2, v0, [Landroid/support/v4/provider/DocumentFile;

    .line 103
    const/4 v0, 0x0

    :goto_0
    array-length v3, v1

    if-ge v0, v3, :cond_0

    .line 104
    new-instance v3, Landroid/support/v4/provider/TreeDocumentFile;

    iget-object v4, p0, Landroid/support/v4/provider/TreeDocumentFile;->a:Landroid/content/Context;

    aget-object v5, v1, v0

    invoke-direct {v3, p0, v4, v5}, Landroid/support/v4/provider/TreeDocumentFile;-><init>(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V

    aput-object v3, v2, v0

    .line 103
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 106
    :cond_0
    return-object v2
.end method
