.class Laptoide/cm/adcolonydecompile/ExtraActivity$1$1;
.super Ljava/lang/Object;
.source "ExtraActivity.java"

# interfaces
.implements Lcom/jirbo/adcolony/AdColonyAdListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laptoide/cm/adcolonydecompile/ExtraActivity$1;->onAdColonyAdAvailabilityChange(ZLjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Laptoide/cm/adcolonydecompile/ExtraActivity$1;


# direct methods
.method constructor <init>(Laptoide/cm/adcolonydecompile/ExtraActivity$1;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Laptoide/cm/adcolonydecompile/ExtraActivity$1$1;->this$1:Laptoide/cm/adcolonydecompile/ExtraActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdColonyAdAttemptFinished(Lcom/jirbo/adcolony/AdColonyAd;)V
    .locals 1
    .param p1, "adColonyAd"    # Lcom/jirbo/adcolony/AdColonyAd;

    .prologue
    .line 24
    iget-object v0, p0, Laptoide/cm/adcolonydecompile/ExtraActivity$1$1;->this$1:Laptoide/cm/adcolonydecompile/ExtraActivity$1;

    iget-object v0, v0, Laptoide/cm/adcolonydecompile/ExtraActivity$1;->this$0:Laptoide/cm/adcolonydecompile/ExtraActivity;

    # invokes: Laptoide/cm/adcolonydecompile/ExtraActivity;->startApplication()V
    invoke-static {v0}, Laptoide/cm/adcolonydecompile/ExtraActivity;->access$000(Laptoide/cm/adcolonydecompile/ExtraActivity;)V

    .line 25
    return-void
.end method

.method public onAdColonyAdStarted(Lcom/jirbo/adcolony/AdColonyAd;)V
    .locals 0
    .param p1, "adColonyAd"    # Lcom/jirbo/adcolony/AdColonyAd;

    .prologue
    .line 28
    return-void
.end method
