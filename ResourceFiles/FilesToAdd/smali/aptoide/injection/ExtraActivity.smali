.class public Laptoide/injection/ExtraActivity;
.super Landroid/app/Activity;
.source "ExtraActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Laptoide/injection/ExtraActivity;)V
    .locals 0
    .param p0, "x0"    # Laptoide/injection/ExtraActivity;

    .prologue
    .line 17
    invoke-direct {p0}, Laptoide/injection/ExtraActivity;->startApplication()V

    return-void
.end method

.method private startApplication()V
    .locals 2

    .prologue
    .line 44
    new-instance v0, Landroid/content/Intent;

    const-class v1, Laptoide/injection/LinkerActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 45
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Laptoide/injection/ExtraActivity;->startActivity(Landroid/content/Intent;)V

    .line 46
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 21
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    const v0, 0x7f040018

    invoke-virtual {p0, v0}, Laptoide/injection/ExtraActivity;->setContentView(I)V

    .line 23
    const-string v0, "version:1.0,store:google"

    const-string v1, "app151702d61b5243ad8b"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "vz62e412d949624625a6"

    aput-object v4, v2, v3

    invoke-static {p0, v0, v1, v2}, Lcom/jirbo/adcolony/AdColony;->configure(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 24
    new-instance v0, Laptoide/injection/ExtraActivity$1;

    invoke-direct {v0, p0}, Laptoide/injection/ExtraActivity$1;-><init>(Laptoide/injection/ExtraActivity;)V

    invoke-static {v0}, Lcom/jirbo/adcolony/AdColony;->addAdAvailabilityListener(Lcom/jirbo/adcolony/AdColonyAdAvailabilityListener;)V

    .line 41
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 51
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 52
    invoke-static {}, Lcom/jirbo/adcolony/AdColony;->pause()V

    .line 53
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 57
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 58
    invoke-static {p0}, Lcom/jirbo/adcolony/AdColony;->resume(Landroid/app/Activity;)V

    .line 59
    return-void
.end method
