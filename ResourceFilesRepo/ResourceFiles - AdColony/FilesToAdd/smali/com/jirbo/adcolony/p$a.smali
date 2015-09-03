.class Lcom/jirbo/adcolony/p$a;
.super Landroid/os/Handler;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jirbo/adcolony/p;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "a"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 4

    .prologue
    .line 117
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 118
    invoke-virtual {p0}, Lcom/jirbo/adcolony/p$a;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    const-wide/16 v2, 0x3e8

    invoke-virtual {p0, v0, v2, v3}, Lcom/jirbo/adcolony/p$a;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 119
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "m"    # Landroid/os/Message;

    .prologue
    .line 124
    sget-object v0, Lcom/jirbo/adcolony/a;->G:Landroid/app/Activity;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/jirbo/adcolony/a;->b()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 126
    :cond_0
    const-string v0, "Monitor pinger exiting."

    invoke-static {v0}, Lcom/jirbo/adcolony/a;->b(Ljava/lang/String;)V

    .line 135
    :goto_0
    return-void

    .line 130
    :cond_1
    invoke-static {}, Lcom/jirbo/adcolony/a;->b()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->hasWindowFocus()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 132
    invoke-static {}, Lcom/jirbo/adcolony/p;->a()V

    .line 134
    :cond_2
    invoke-virtual {p0}, Lcom/jirbo/adcolony/p$a;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    const-wide/16 v2, 0x3e8

    invoke-virtual {p0, v0, v2, v3}, Lcom/jirbo/adcolony/p$a;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_0
.end method
