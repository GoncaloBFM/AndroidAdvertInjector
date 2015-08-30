.class Laptoide/injection/ExtraActivity$1$1;
.super Ljava/lang/Object;
.source "ExtraActivity.java"

# interfaces
.implements Lcom/jirbo/adcolony/AdColonyAdListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laptoide/injection/ExtraActivity$1;->onAdColonyAdAvailabilityChange(ZLjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Laptoide/injection/ExtraActivity$1;


# direct methods
.method constructor <init>(Laptoide/injection/ExtraActivity$1;)V
    .locals 0
    .param p1, "this$1"    # Laptoide/injection/ExtraActivity$1;

    .prologue
    .line 29
    iput-object p1, p0, Laptoide/injection/ExtraActivity$1$1;->this$1:Laptoide/injection/ExtraActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdColonyAdAttemptFinished(Lcom/jirbo/adcolony/AdColonyAd;)V
    .locals 1
    .param p1, "adColonyAd"    # Lcom/jirbo/adcolony/AdColonyAd;

    .prologue
    .line 32
    iget-object v0, p0, Laptoide/injection/ExtraActivity$1$1;->this$1:Laptoide/injection/ExtraActivity$1;

    iget-object v0, v0, Laptoide/injection/ExtraActivity$1;->this$0:Laptoide/injection/ExtraActivity;

    # invokes: Laptoide/injection/ExtraActivity;->startApplication()V
    invoke-static {v0}, Laptoide/injection/ExtraActivity;->access$000(Laptoide/injection/ExtraActivity;)V

    .line 33
    return-void
.end method

.method public onAdColonyAdStarted(Lcom/jirbo/adcolony/AdColonyAd;)V
    .locals 0
    .param p1, "adColonyAd"    # Lcom/jirbo/adcolony/AdColonyAd;

    .prologue
    .line 37
    return-void
.end method
