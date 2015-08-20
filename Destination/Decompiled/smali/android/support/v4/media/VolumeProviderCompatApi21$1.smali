.class final Landroid/support/v4/media/VolumeProviderCompatApi21$1;
.super Landroid/media/VolumeProvider;
.source "VolumeProviderCompatApi21.java"


# instance fields
.field final synthetic a:Landroid/support/v4/media/VolumeProviderCompatApi21$Delegate;


# virtual methods
.method public onAdjustVolume(I)V
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Landroid/support/v4/media/VolumeProviderCompatApi21$1;->a:Landroid/support/v4/media/VolumeProviderCompatApi21$Delegate;

    invoke-interface {v0, p1}, Landroid/support/v4/media/VolumeProviderCompatApi21$Delegate;->b(I)V

    .line 33
    return-void
.end method

.method public onSetVolumeTo(I)V
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Landroid/support/v4/media/VolumeProviderCompatApi21$1;->a:Landroid/support/v4/media/VolumeProviderCompatApi21$Delegate;

    invoke-interface {v0, p1}, Landroid/support/v4/media/VolumeProviderCompatApi21$Delegate;->a(I)V

    .line 28
    return-void
.end method
