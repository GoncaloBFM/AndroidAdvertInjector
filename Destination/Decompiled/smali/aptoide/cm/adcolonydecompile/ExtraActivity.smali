.class public Laptoide/cm/adcolonydecompile/ExtraActivity;
.super Landroid/app/Activity;
.source "ExtraActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Laptoide/cm/adcolonydecompile/ExtraActivity;)V
    .locals 0
    .param p0, "x0"    # Laptoide/cm/adcolonydecompile/ExtraActivity;

    .prologue
    .line 9
    invoke-direct {p0}, Laptoide/cm/adcolonydecompile/ExtraActivity;->startApplication()V

    return-void
.end method

.method private startApplication()V
    .locals 2

    .prologue
    .line 35
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/dotgears/flappy/SplashScreen;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 36
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Laptoide/cm/adcolonydecompile/ExtraActivity;->startActivity(Landroid/content/Intent;)V

    .line 37
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 13
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 14
    const v0, 0x7f030001

    invoke-virtual {p0, v0}, Laptoide/cm/adcolonydecompile/ExtraActivity;->setContentView(I)V

    .line 15
    const-string v0, "version:1.0,store:google"

    const-string v1, "app151702d61b5243ad8b"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "vz62e412d949624625a6"

    aput-object v4, v2, v3

    invoke-static {p0, v0, v1, v2}, Lcom/jirbo/adcolony/AdColony;->configure(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 16
    new-instance v0, Laptoide/cm/adcolonydecompile/ExtraActivity$1;

    invoke-direct {v0, p0}, Laptoide/cm/adcolonydecompile/ExtraActivity$1;-><init>(Laptoide/cm/adcolonydecompile/ExtraActivity;)V

    invoke-static {v0}, Lcom/jirbo/adcolony/AdColony;->addAdAvailabilityListener(Lcom/jirbo/adcolony/AdColonyAdAvailabilityListener;)V

    .line 32
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 42
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 43
    invoke-static {}, Lcom/jirbo/adcolony/AdColony;->pause()V

    .line 44
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 48
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 49
    invoke-static {p0}, Lcom/jirbo/adcolony/AdColony;->resume(Landroid/app/Activity;)V

    .line 50
    return-void
.end method
