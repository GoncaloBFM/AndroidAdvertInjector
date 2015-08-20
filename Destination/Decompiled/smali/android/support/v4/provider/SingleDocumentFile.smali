.class Landroid/support/v4/provider/SingleDocumentFile;
.super Landroid/support/v4/provider/DocumentFile;
.source "SingleDocumentFile.java"


# instance fields
.field private a:Landroid/content/Context;

.field private b:Landroid/net/Uri;


# virtual methods
.method public a()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Landroid/support/v4/provider/SingleDocumentFile;->b:Landroid/net/Uri;

    return-object v0
.end method

.method public a(Ljava/lang/String;)Landroid/support/v4/provider/DocumentFile;
    .locals 1

    .prologue
    .line 40
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)Landroid/support/v4/provider/DocumentFile;
    .locals 1

    .prologue
    .line 35
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public b()Ljava/lang/String;
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Landroid/support/v4/provider/SingleDocumentFile;->a:Landroid/content/Context;

    iget-object v1, p0, Landroid/support/v4/provider/SingleDocumentFile;->b:Landroid/net/Uri;

    invoke-static {v0, v1}, Landroid/support/v4/provider/DocumentsContractApi19;->a(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public c()[Landroid/support/v4/provider/DocumentFile;
    .locals 1

    .prologue
    .line 100
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
