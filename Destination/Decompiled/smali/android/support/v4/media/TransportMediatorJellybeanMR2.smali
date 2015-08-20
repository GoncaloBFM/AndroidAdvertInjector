.class Landroid/support/v4/media/TransportMediatorJellybeanMR2;
.super Ljava/lang/Object;
.source "TransportMediatorJellybeanMR2.java"

# interfaces
.implements Landroid/media/RemoteControlClient$OnGetPlaybackPositionListener;
.implements Landroid/media/RemoteControlClient$OnPlaybackPositionUpdateListener;


# instance fields
.field final a:Landroid/content/Context;

.field final b:Landroid/media/AudioManager;

.field final c:Landroid/support/v4/media/TransportMediatorCallback;

.field final d:Landroid/content/IntentFilter;

.field final e:Landroid/content/Intent;

.field final f:Landroid/content/BroadcastReceiver;

.field g:Landroid/media/AudioManager$OnAudioFocusChangeListener;

.field h:Landroid/app/PendingIntent;

.field i:Landroid/media/RemoteControlClient;

.field j:Z

.field k:I

.field l:Z


# virtual methods
.method a()V
    .locals 4

    .prologue
    .line 111
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->a:Landroid/content/Context;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->f:Landroid/content/BroadcastReceiver;

    iget-object v2, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->d:Landroid/content/IntentFilter;

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 112
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->a:Landroid/content/Context;

    const/4 v1, 0x0

    iget-object v2, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->e:Landroid/content/Intent;

    const/high16 v3, 0x10000000

    invoke-static {v0, v1, v2, v3}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->h:Landroid/app/PendingIntent;

    .line 114
    new-instance v0, Landroid/media/RemoteControlClient;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->h:Landroid/app/PendingIntent;

    invoke-direct {v0, v1}, Landroid/media/RemoteControlClient;-><init>(Landroid/app/PendingIntent;)V

    iput-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->i:Landroid/media/RemoteControlClient;

    .line 115
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->i:Landroid/media/RemoteControlClient;

    invoke-virtual {v0, p0}, Landroid/media/RemoteControlClient;->setOnGetPlaybackPositionListener(Landroid/media/RemoteControlClient$OnGetPlaybackPositionListener;)V

    .line 116
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->i:Landroid/media/RemoteControlClient;

    invoke-virtual {v0, p0}, Landroid/media/RemoteControlClient;->setPlaybackPositionUpdateListener(Landroid/media/RemoteControlClient$OnPlaybackPositionUpdateListener;)V

    .line 117
    return-void
.end method

.method b()V
    .locals 2

    .prologue
    .line 120
    iget-boolean v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->j:Z

    if-nez v0, :cond_0

    .line 121
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->j:Z

    .line 122
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->b:Landroid/media/AudioManager;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->h:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->registerMediaButtonEventReceiver(Landroid/app/PendingIntent;)V

    .line 123
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->b:Landroid/media/AudioManager;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->i:Landroid/media/RemoteControlClient;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->registerRemoteControlClient(Landroid/media/RemoteControlClient;)V

    .line 124
    iget v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->k:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    .line 125
    invoke-virtual {p0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->c()V

    .line 128
    :cond_0
    return-void
.end method

.method c()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 131
    iget-boolean v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->l:Z

    if-nez v0, :cond_0

    .line 132
    iput-boolean v3, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->l:Z

    .line 133
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->b:Landroid/media/AudioManager;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->g:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    const/4 v2, 0x3

    invoke-virtual {v0, v1, v2, v3}, Landroid/media/AudioManager;->requestAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I

    .line 136
    :cond_0
    return-void
.end method

.method d()V
    .locals 2

    .prologue
    .line 183
    iget-boolean v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->l:Z

    if-eqz v0, :cond_0

    .line 184
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->l:Z

    .line 185
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->b:Landroid/media/AudioManager;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->g:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->abandonAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;)I

    .line 187
    :cond_0
    return-void
.end method

.method e()V
    .locals 2

    .prologue
    .line 190
    invoke-virtual {p0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->d()V

    .line 191
    iget-boolean v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->j:Z

    if-eqz v0, :cond_0

    .line 192
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->j:Z

    .line 193
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->b:Landroid/media/AudioManager;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->i:Landroid/media/RemoteControlClient;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->unregisterRemoteControlClient(Landroid/media/RemoteControlClient;)V

    .line 194
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->b:Landroid/media/AudioManager;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->h:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->unregisterMediaButtonEventReceiver(Landroid/app/PendingIntent;)V

    .line 196
    :cond_0
    return-void
.end method

.method f()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 199
    invoke-virtual {p0}, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->e()V

    .line 200
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->h:Landroid/app/PendingIntent;

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->a:Landroid/content/Context;

    iget-object v1, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->f:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 202
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->h:Landroid/app/PendingIntent;

    invoke-virtual {v0}, Landroid/app/PendingIntent;->cancel()V

    .line 203
    iput-object v2, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->h:Landroid/app/PendingIntent;

    .line 204
    iput-object v2, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->i:Landroid/media/RemoteControlClient;

    .line 206
    :cond_0
    return-void
.end method

.method public onGetPlaybackPosition()J
    .locals 2

    .prologue
    .line 150
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->c:Landroid/support/v4/media/TransportMediatorCallback;

    invoke-interface {v0}, Landroid/support/v4/media/TransportMediatorCallback;->a()J

    move-result-wide v0

    return-wide v0
.end method

.method public onPlaybackPositionUpdate(J)V
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Landroid/support/v4/media/TransportMediatorJellybeanMR2;->c:Landroid/support/v4/media/TransportMediatorCallback;

    invoke-interface {v0, p1, p2}, Landroid/support/v4/media/TransportMediatorCallback;->a(J)V

    .line 156
    return-void
.end method
