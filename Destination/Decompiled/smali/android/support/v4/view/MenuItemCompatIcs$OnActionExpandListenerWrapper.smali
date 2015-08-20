.class Landroid/support/v4/view/MenuItemCompatIcs$OnActionExpandListenerWrapper;
.super Ljava/lang/Object;
.source "MenuItemCompatIcs.java"

# interfaces
.implements Landroid/view/MenuItem$OnActionExpandListener;


# instance fields
.field private a:Landroid/support/v4/view/MenuItemCompatIcs$SupportActionExpandProxy;


# virtual methods
.method public onMenuItemActionCollapse(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Landroid/support/v4/view/MenuItemCompatIcs$OnActionExpandListenerWrapper;->a:Landroid/support/v4/view/MenuItemCompatIcs$SupportActionExpandProxy;

    invoke-interface {v0, p1}, Landroid/support/v4/view/MenuItemCompatIcs$SupportActionExpandProxy;->b(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onMenuItemActionExpand(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Landroid/support/v4/view/MenuItemCompatIcs$OnActionExpandListenerWrapper;->a:Landroid/support/v4/view/MenuItemCompatIcs$SupportActionExpandProxy;

    invoke-interface {v0, p1}, Landroid/support/v4/view/MenuItemCompatIcs$SupportActionExpandProxy;->a(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method
