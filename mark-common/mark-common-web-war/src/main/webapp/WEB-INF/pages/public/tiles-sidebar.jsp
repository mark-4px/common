<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--logo and iconic logo start-->
<div class="logo">
    <a href="/common/dashboard"><img src="/images/logo.png" alt=""></a>
</div>

<div class="logo-icon text-center">
    <a href="/common/dashboard"><img src="/images/logo_icon.png" alt=""></a>
</div>
<!--logo and iconic logo end-->

<div class="left-side-inner">

    <!-- visible to small devices only -->
    <div class="visible-xs hidden-sm hidden-md hidden-lg">
        <div class="media logged-user">
            <img alt="" src="/images/photos/user-avatar.png" class="media-object">
            <div class="media-body">
                <h4><a href="#">John Doe</a></h4>
                <span>"Hello There..."</span>
            </div>
        </div>

        <h5 class="left-nav-title">Account Information</h5>
        <ul class="nav nav-pills nav-stacked custom-nav">
          <li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
          <li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
          <li><a href="#"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
        </ul>
    </div>

    <!--sidebar nav start-->
    <ul class="nav nav-pills nav-stacked custom-nav">
    	<li class="active"><a href="/common/dashboard"><i class="fa fa-sign-in"></i> <span>看板</span></a></li>
        
        <li class="menu-list"><a href="index.html"><i class="fa fa-home"></i> <span>基础代码</span></a>
            <ul class="sub-menu-list">
            	<li><a href="/widgets/text"> 文字  </a></li>
            	<li><a href="/widgets/button"> 按钮  </a></li>
                <li><a href="/widgets/form"> 表单  </a></li>
                <li><a href="/widgets/table"> 表格  </a></li>
                <li><a href="/widgets/dialog"> 对话框  </a></li>
                <li><a href="/widgets/slider"> slider  </a></li>
                <li><a href="/widgets/gallery"> gallery  </a></li>
            </ul>
        </li>
        
        <li class="menu-list"><a href="index.html"><i class="fa fa-home"></i> <span>功能组件</span></a>
            <ul class="sub-menu-list">
            	<li><a href="/component/button"> 按钮  </a></li>
                <li><a href="/component/simple_form"> 普通表单  </a></li>
                <li><a href="/component/form_validation"> 表单校验  </a></li>
                <li><a href="/component/pageable_table"> 分页表格  </a></li>
                <li><a href="/component/pageable_table"> 遮罩  </a></li>
                <li><a href="/component/pageable_table"> 提示信息  </a></li>
                <li><a href="/component/pageable_table"> 分页表格  </a></li>
                
            </ul>
        </li>
        
        <li class="menu-list"><a href="index.html"><i class="fa fa-home"></i> <span>插件</span></a>
            <ul class="sub-menu-list">
            	<li><a href="/plugins/iconfont"> iconfont字体库  </a></li>
            	<li><a href="/plugins/button"> Ladda按钮  </a></li>
                <li><a href="/plugins/form_validation"> select2  </a></li>
                <li><a href="/plugins/pageable_table"> icheck  </a></li>
                <li><a href="/plugins/pageable_table"> toastr  </a></li>
                <li><a href="/plugins/pageable_table"> highlightjs  </a></li>
                <li><a href="/plugins/pageable_table"> datepicker  </a></li>
                <li><a href="/plugins/pageable_table"> animate.css  </a></li>
                <li><a href="/plugins/pageable_table"> bootstrap switch  </a></li>
                <li><a href="/plugins/pageable_table"> dropzone  </a></li>
                <li><a href="/plugins/pageable_table"> echarts  </a></li>
                <li><a href="/plugins/pageable_table"> full calendar  </a></li>
                <li><a href="/plugins/pageable_table"> lightbox  </a></li>
                <li><a href="/plugins/pageable_table"> ueditor  </a></li>
                <li><a href="/plugins/pageable_table"> uploader  </a></li>
            </ul>
        </li>
        
        <li class="menu-list"><a href="index.html"><i class="fa fa-home"></i> <span>权限管理</span></a>
            <ul class="sub-menu-list">
                <li><a href="/rbac/user_list"> 人员列表 </a></li>
                <li><a href="/rbac/role_list"> 角色列表 </a></li>
                <li><a href="/rbac/resource_list"> 资源列表 </a></li>
            </ul>
        </li>
    </ul>
    <!--sidebar nav end-->

</div>