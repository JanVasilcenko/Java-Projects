#pragma checksum "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\Component.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "44ac60c0064c8d809fb22f672bc2549808ede960"
// <auto-generated/>
#pragma warning disable 1591
namespace Client.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Client;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Client.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Radzen;

#line default
#line hidden
#nullable disable
#nullable restore
#line 11 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Radzen.Blazor;

#line default
#line hidden
#nullable disable
#nullable restore
#line 12 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Blazored;

#line default
#line hidden
#nullable disable
#nullable restore
#line 13 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Blazored.Toast;

#line default
#line hidden
#nullable disable
#nullable restore
#line 14 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Blazored.Toast.Services;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/errorPage")]
    public partial class Component : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenElement(0, "div");
            __builder.AddAttribute(1, "class", "section");
            __builder.AddMarkupContent(2, "\r\n    ");
            __builder.OpenElement(3, "div");
            __builder.AddAttribute(4, "class", "section-center");
            __builder.AddMarkupContent(5, "\r\n        ");
            __builder.OpenElement(6, "div");
            __builder.AddAttribute(7, "class", "container justify-content-center d-flex text-center");
            __builder.AddMarkupContent(8, "\r\n            ");
            __builder.OpenElement(9, "div");
            __builder.AddAttribute(10, "class", "card-error");
            __builder.AddMarkupContent(11, "\r\n                ");
            __builder.AddMarkupContent(12, "<div style=\"border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto; text-align:center;\" class=\"rotate-vert-center \">\r\n                    <span class=\"cross \">:x:</span>\r\n                </div>\r\n                ");
            __builder.AddMarkupContent(13, "<h1>Error</h1>\r\n                ");
            __builder.AddMarkupContent(14, "<p>There was an error when choosing a seat.</p>\r\n                ");
            __builder.AddMarkupContent(15, "<p>Please try again</p>\r\n                ");
            __builder.OpenElement(16, "div");
            __builder.AddAttribute(17, "class", "row justify-content-center");
            __builder.AddMarkupContent(18, "\r\n                    ");
            __builder.OpenElement(19, "button");
            __builder.AddAttribute(20, "class", "yellow-btn");
            __builder.AddAttribute(21, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 16 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\Component.razor"
                                                         GoBack

#line default
#line hidden
#nullable disable
            ));
            __builder.AddContent(22, "Go back");
            __builder.CloseElement();
            __builder.AddMarkupContent(23, "\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(24, "\r\n\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(25, "\r\n        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(26, "\r\n    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(27, "\r\n");
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 24 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\Component.razor"
       
    private void GoBack() 
    {
        navigationManager.NavigateTo("/searchflight");
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager navigationManager { get; set; }
    }
}
#pragma warning restore 1591
