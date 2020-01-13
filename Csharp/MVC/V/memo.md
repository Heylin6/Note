 
 
@Html.LabelFor(m => m.Email, new { @class = "col-md-2 control-label" })

@Html.TextBoxFor(m => m.Email, new { @class = "form-control" })

@Html.ValidationMessageFor(m => m.Email, "", new { @class = "text-danger" })

@Html.PasswordFor(m => m.Password, new { @class = "form-control" })

@Html.CheckBoxFor(m => m.RememberMe)

@Html.ActionLink("刪除", "DelAccount", new { AID = item.AccountID }, new { onclick = "return confirm('確定進行刪除?');" })

@Html.DropDownListFor(model => model.SelectedProvider, Model.Providers)

@Html.PagedListPager(Model.Account, page => Url.Action("Index", new { page }))

@Html.AntiForgeryToken()

@Html.ValidationSummary(true, "", new { @class = "text-danger" })

@Html.TextBoxFor(model => model.aa, new { @readonly = "readonly" })

@Html.HiddenFor(model => model.NPID)

==========================

        <section class="pages0">
            @RenderPage("~/Views/ChildPage/Index_Banner.cshtml")
        </section>

==========================

@using (Html.BeginForm("SendCode", "Account", new { ReturnUrl = Model.ReturnUrl }, FormMethod.Post, new { @class = "form-horizontal", role = "form" })) {
    
}

==========================

@{
    ViewBag.Title = "傳送";
}

<h2>@ViewBag.Title.</h2>

==========================

@{
    Layout = "~/Views/Shared/aaa.cshtml";
    ViewBag.Title = "設置";

    var link = Html.ActionLink("{0}", "Create", null, new { @class = "shortcut-button" }).ToString();
    var url = string.Format(link, "<span>新增</span>");
}

@Html.Raw(url)

==========================    