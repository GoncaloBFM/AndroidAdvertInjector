.class Landroid/support/v4/app/FragmentManagerImpl$3;
.super Ljava/lang/Object;
.source "FragmentManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:I

.field final synthetic c:Landroid/support/v4/app/FragmentManagerImpl;


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 509
    iget-object v0, p0, Landroid/support/v4/app/FragmentManagerImpl$3;->c:Landroid/support/v4/app/FragmentManagerImpl;

    iget-object v1, p0, Landroid/support/v4/app/FragmentManagerImpl$3;->c:Landroid/support/v4/app/FragmentManagerImpl;

    iget-object v1, v1, Landroid/support/v4/app/FragmentManagerImpl;->o:Landroid/support/v4/app/FragmentActivity;

    iget-object v1, v1, Landroid/support/v4/app/FragmentActivity;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Landroid/support/v4/app/FragmentManagerImpl$3;->a:Ljava/lang/String;

    const/4 v3, -0x1

    iget v4, p0, Landroid/support/v4/app/FragmentManagerImpl$3;->b:I

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/app/FragmentManagerImpl;->a(Landroid/os/Handler;Ljava/lang/String;II)Z

    .line 510
    return-void
.end method
