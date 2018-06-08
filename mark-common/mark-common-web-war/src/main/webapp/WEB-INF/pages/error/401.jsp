<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="page-content" style="background:#ecf0f5;">
     <div class="row">
            <div class="col-xs-12">
                <div class="error-container">
                    <div class="well">
                        <h1 class="grey lighter smaller">
                            <span class="red bigger-125">
                                <i class="fa fa-random"></i>
                                401
                            </span>
                           errCode:${data.errCode}
                        </h1>
                        <hr>
                        <h3 class="lighter smaller">
							errMsg:${data.errMsg}
							<i class="ace-icon fa fa-wrench icon-animated-wrench bigger-125"></i>
						</h3>
                        <div class="space"></div>
                        <div>
                            <h4 class="lighter smaller">同时, 可以尝试以下意见:</h4>
                            <ul class="list-unstyled spaced margin-15">
                                <li>
                                    <i class="fa fa-angle-right blue"></i>
                                    <a href="#">阅读常见问题</a>
                                </li>
                                <li>
                                    <i class="fa fa-angle-right blue"></i>
                                    <a href="#">联系系统管理</a>
                                </li>
                            </ul>
                        </div>
                        <hr>
                        <div class="space"></div>
                        <div class="center">
                            <a href="javascript:window.top.location.reload()" class="btn btn-primary">
                                <i class="fa fa-home"></i> 首页
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
