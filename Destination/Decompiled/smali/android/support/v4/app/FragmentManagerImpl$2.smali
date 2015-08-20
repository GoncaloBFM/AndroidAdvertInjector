.class Landroid/support/v4/app/FragmentManagerImpl$2;
.super Ljava/lang/Object;
.source "FragmentManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Landroid/support/v4/app/FragmentManagerImpl;


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 493
    iget-object v0, p0, Landroid/support/v4/app/FragmentManagerImpl$2;->a:Landroid/support/v4/app/FragmentManagerImpl;

    iget-object v1, p0, Landroid/support/v4/app/FragmentManagerImpl$2;->a:Landroid/support/v4/app/FragmentManagerImpl;

    iget-object v1, v1, Landroid/support/v4/app/FragmentManagerImpl;->o:Landroid/support/v4/app/FragmentActivity;

    iget-object v1, v1, Landroid/support/v4/app/FragmentActivity;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x0

    const/4 v3, -0x1

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/app/FragmentManagerImpl;->a(Landroid/os/Handler;Ljava/lang/String;II)Z

    .line 494
    return-void
.end method
