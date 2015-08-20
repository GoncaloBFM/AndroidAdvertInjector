.class public Landroid/support/v4/app/ActivityCompat;
.super Landroid/support/v4/content/ContextCompat;
.source "ActivityCompat.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/support/v4/content/ContextCompat;-><init>()V

    .line 217
    return-void
.end method

.method private static a(Landroid/support/v4/app/SharedElementCallback;)Landroid/support/v4/app/ActivityCompat21$SharedElementCallback21;
    .locals 1

    .prologue
    .line 210
    const/4 v0, 0x0

    .line 211
    if-eqz p0, :cond_0

    .line 212
    new-instance v0, Landroid/support/v4/app/ActivityCompat$SharedElementCallback21Impl;

    invoke-direct {v0, p0}, Landroid/support/v4/app/ActivityCompat$SharedElementCallback21Impl;-><init>(Landroid/support/v4/app/SharedElementCallback;)V

    .line 214
    :cond_0
    return-object v0
.end method

.method public static a(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 158
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 159
    invoke-static {p0}, Landroid/support/v4/app/ActivityCompat21;->a(Landroid/app/Activity;)V

    .line 163
    :goto_0
    return-void

    .line 161
    :cond_0
    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    goto :goto_0
.end method

.method public static a(Landroid/app/Activity;Landroid/support/v4/app/SharedElementCallback;)V
    .locals 2

    .prologue
    .line 175
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 176
    invoke-static {p1}, Landroid/support/v4/app/ActivityCompat;->a(Landroid/support/v4/app/SharedElementCallback;)Landroid/support/v4/app/ActivityCompat21$SharedElementCallback21;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/support/v4/app/ActivityCompat21;->a(Landroid/app/Activity;Landroid/support/v4/app/ActivityCompat21$SharedElementCallback21;)V

    .line 178
    :cond_0
    return-void
.end method

.method public static b(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 197
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 198
    invoke-static {p0}, Landroid/support/v4/app/ActivityCompat21;->b(Landroid/app/Activity;)V

    .line 200
    :cond_0
    return-void
.end method

.method public static b(Landroid/app/Activity;Landroid/support/v4/app/SharedElementCallback;)V
    .locals 2

    .prologue
    .line 191
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 192
    invoke-static {p1}, Landroid/support/v4/app/ActivityCompat;->a(Landroid/support/v4/app/SharedElementCallback;)Landroid/support/v4/app/ActivityCompat21$SharedElementCallback21;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/support/v4/app/ActivityCompat21;->b(Landroid/app/Activity;Landroid/support/v4/app/ActivityCompat21$SharedElementCallback21;)V

    .line 194
    :cond_0
    return-void
.end method

.method public static c(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 203
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 204
    invoke-static {p0}, Landroid/support/v4/app/ActivityCompat21;->c(Landroid/app/Activity;)V

    .line 206
    :cond_0
    return-void
.end method
