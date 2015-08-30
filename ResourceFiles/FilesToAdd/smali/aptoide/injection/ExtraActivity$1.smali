.class Laptoide/injection/ExtraActivity$1;
.super Ljava/lang/Object;
.source "ExtraActivity.java"

# interfaces
.implements Lcom/jirbo/adcolony/AdColonyAdAvailabilityListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laptoide/injection/ExtraActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Laptoide/injection/ExtraActivity;


# direct methods
.method constructor <init>(Laptoide/injection/ExtraActivity;)V
    .locals 0
    .param p1, "this$0"    # Laptoide/injection/ExtraActivity;

    .prologue
    .line 24
    iput-object p1, p0, Laptoide/injection/ExtraActivity$1;->this$0:Laptoide/injection/ExtraActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdColonyAdAvailabilityChange(ZLjava/lang/String;)V
    .locals 2
    .param p1, "b"    # Z
    .param p2, "s"    # Ljava/lang/String;

    .prologue
    .line 27
    new-instance v0, Lcom/jirbo/adcolony/AdColonyVideoAd;

    invoke-direct {v0}, Lcom/jirbo/adcolony/AdColonyVideoAd;-><init>()V

    .line 28
    .local v0, "ad":Lcom/jirbo/adcolony/AdColonyVideoAd;
    invoke-virtual {v0}, Lcom/jirbo/adcolony/AdColonyVideoAd;->show()V

    .line 29
    new-instance v1, Laptoide/injection/ExtraActivity$1$1;

    invoke-direct {v1, p0}, Laptoide/injection/ExtraActivity$1$1;-><init>(Laptoide/injection/ExtraActivity$1;)V

    invoke-virtual {v0, v1}, Lcom/jirbo/adcolony/AdColonyVideoAd;->withListener(Lcom/jirbo/adcolony/AdColonyAdListener;)Lcom/jirbo/adcolony/AdColonyVideoAd;

    .line 39
    return-void
.end method
