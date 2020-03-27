<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 定时任务列表
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <el-button type="primary" class="handle-del mr10" icon="el-icon-circle-plus-outline" @click="addTimeTask()">
                新增定时任务
            </el-button>
            <!--<el-button type="success" class="handle-del mr10" icon="el-icon-check">修改定时任务</el-button>-->
            <!--<el-button type="info" class="handle-del mr10" icon="el-icon-zoom-in">查看定时任务</el-button>-->
            <!--<el-button type="danger" class="handle-del mr10" icon="el-icon-delete">删除定时任务</el-button>-->
        </div>
        <el-tabs v-model="tableTabs" @tab-click="tabClick">
            <el-tab-pane label="发送邮件" name="sendMail">
                <el-table
                        :data="timeTaskList"
                        border
                        class="table"
                        ref="sendMailTable"
                        header-cell-class-name="table-header"
                >
                    <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
                    <el-table-column prop="taskName" label="任务名" align="center"></el-table-column>
                    <el-table-column prop="emailAddress" label="发送邮件地址" align="center"></el-table-column>
                    <el-table-column prop="emailSubject" label="邮件主题" align="center"></el-table-column>
                    <el-table-column prop="emailContent" label="邮件内容" align="center"></el-table-column>
                    <el-table-column label="是否指定执行日期" align="center">
                        <template slot-scope="scope">
                            <div v-if="scope.row.isAppoin == 0">
                                否
                            </div>
                            <div v-if="scope.row.isAppoin == 1">
                                是
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column label="执行频度（单位：分钟）" align="center">
                        <template slot-scope="scope">
                            <div v-if="scope.row.isAppoin == 1">
                                0
                            </div>
                            <div v-else-if="scope.row.isAppoin == 0">
                                {{scope.row.frequency}}
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column label="指定日期" align="center">
                        <template slot-scope="scope">
                            <div v-if="scope.row.isAppoin == 1">
                                {{scope.row.appoinDate | formatDataStamp}}
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column prop="personInCharge" label="负责人" align="center"></el-table-column>
                    <el-table-column label="创建时间" align="center">
                        <template slot-scope="scope">
                            {{scope.row.createTime | formatDataStamp}}
                        </template>
                    </el-table-column>
                    <el-table-column label="修改时间" align="center">
                        <template slot-scope="scope">
                            {{scope.row.modifyTime | formatDataStamp}}
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="180" align="center">
                        <template slot-scope="scope">
                            <el-button
                                    type="text"
                                    icon="el-icon-view"
                                    @click="lookTimeTask(scope.row)"
                            >查看
                            </el-button>
                            <el-button
                                    type="text"
                                    icon="el-icon-edit"
                                    @click="editTimeTask(scope.row)"
                            >编辑
                            </el-button>
                            <el-button
                                    type="text"
                                    icon="el-icon-delete"
                                    class="red"
                                    @click="deleteTimeTask(scope.row)"
                            >删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-tab-pane>
            <el-tab-pane label="访问接口" name="sendRequest">
                <el-table
                        :data="timeTaskList"
                        border
                        class="table"
                        ref="sendRequestTable"
                        header-cell-class-name="table-header"
                >
                    <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
                    <el-table-column prop="taskName" label="任务名" align="center"></el-table-column>
                    <el-table-column prop="requestAddress" label="访问地址" align="center"></el-table-column>
                    <el-table-column prop="taskParam" label="请求参数" align="center"></el-table-column>
                    <el-table-column label="请求类型" align="center">
                        <template slot-scope="scope">
                            <div v-if="scope.row.requestMode == 1">
                                get
                            </div>
                            <div v-if="scope.row.requestMode == 2">
                                post 字符串
                            </div>
                            <div v-if="scope.row.requestMode == 3">
                                post 表单
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column label="是否指定执行日期" align="center">
                        <template slot-scope="scope">
                            <div v-if="scope.row.isAppoin == 0">
                                否
                            </div>
                            <div v-if="scope.row.isAppoin == 1">
                                是
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column label="执行频度（单位：分钟）" align="center">
                        <template slot-scope="scope">
                            <div v-if="scope.row.isAppoin == 1">
                                0
                            </div>
                            <div v-else-if="scope.row.isAppoin == 0">
                                {{scope.row.frequency}}
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column label="指定日期" align="center">
                        <template slot-scope="scope">
                            <div v-if="scope.row.isAppoin == 1">
                                {{scope.row.appoinDate | formatDataStamp}}
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column prop="personInCharge" label="负责人" align="center"></el-table-column>
                    <el-table-column label="创建时间" align="center">
                        <template slot-scope="scope">
                            {{scope.row.createTime | formatDataStamp}}
                        </template>
                    </el-table-column>
                    <el-table-column label="修改时间" align="center">
                        <template slot-scope="scope">
                            {{scope.row.modifyTime | formatDataStamp}}
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="180" align="center">
                        <template slot-scope="scope">
                            <el-button
                                    type="text"
                                    icon="el-icon-view"
                                    @click="lookTimeTask(scope.row)"
                            >查看
                            </el-button>
                            <el-button
                                    type="text"
                                    icon="el-icon-edit"
                                    @click="editTimeTask(scope.row)"
                            >编辑
                            </el-button>
                            <el-button
                                    type="text"
                                    icon="el-icon-delete"
                                    class="red"
                                    @click="deleteTimeTask(scope.row)"
                            >删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-tab-pane>
        </el-tabs>
        <!--分页控件开始-->
        <div class="block">
            <el-pagination
                    @size-change="pageSizeChange"
                    @current-change="pageChange"
                    :page-sizes="[10, 20, 30, 50]"
                    :page-size=pageSize
                    layout="sizes, prev, pager, next"
                    :total=timeTaskCount>
            </el-pagination>
        </div>
        <!--分页控件结束-->
        <!--创建修改查看弹窗开始-->
        <el-dialog
                :title="timeTaskTitle"
                :visible.sync="dialogVisible"
                width="80%"
                :before-close="handleClose">
            <el-form ref="form" :model="timeTask">
                <el-form-item label="任务名称">
                    <el-input v-model="timeTask.taskName" :disabled="status=='look'"></el-input>
                </el-form-item>
                <el-form-item label="任务类别">
                    <el-radio-group v-model="timeTask.taskCategory" :disabled="status=='look'">
                        <el-radio :label="1" value="1">发送邮件</el-radio>
                        <el-radio :label="2" value="2">请求接口</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="邮箱地址" v-if="timeTask.taskCategory==1">
                    <el-input v-model="timeTask.emailAddress" :disabled="status=='look'"></el-input>
                </el-form-item>
                <el-form-item label="邮件主题" v-if="timeTask.taskCategory==1">
                    <el-input v-model="timeTask.emailSubject" :disabled="status=='look'"></el-input>
                </el-form-item>
                <el-form-item label="邮件内容" v-if="timeTask.taskCategory==1">
                    <el-input v-model="timeTask.emailContent" :disabled="status=='look'"></el-input>
                </el-form-item>
                <el-form-item label="任务类别" v-if="timeTask.taskCategory==2">
                    <el-radio-group v-model="timeTask.requestMode" :disabled="status=='look'">
                        <el-radio :label="1" value="1">get</el-radio>
                        <el-radio :label="2" value="2">post application/json</el-radio>
                        <el-radio :label="3" value="3">post from</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="请求地址" v-if="timeTask.taskCategory==2">
                    <el-input v-model="timeTask.requestAddress" :disabled="status=='look'"></el-input>
                </el-form-item>
                <el-form-item label="请求参数" v-if="timeTask.taskCategory==2">
                    <vueJsonEditor v-model="timeTask.taskParam" :disabled="status=='look'"></vueJsonEditor>
                </el-form-item>
                <el-form-item label="是否指定执行日期">
                    <el-radio-group v-model="timeTask.isAppoin" :disabled="status=='look'">
                        <el-radio :label="0" value="0">否</el-radio>
                        <el-radio :label="1" value="1">是</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="执行频度  单位分钟" v-if="timeTask.isAppoin==0">
                    <el-input-number v-model="timeTask.frequency" :disabled="status=='look'"></el-input-number>
                </el-form-item>
                <el-form-item label="日期时间" v-if="timeTask.isAppoin==1">
                    <el-col :span="11">
                        <el-date-picker
                                type="date"
                                placeholder="选择日期"
                                v-model="timeTask.appoinDate"
                                value-format="yyyy-MM-dd"
                                style="width: 100%;" :disabled="status=='look'"
                        ></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="负责人">
                    <el-input v-model="timeTask.personInCharge" :disabled="status=='look'"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveTimeTask()" v-if="status!='look'">确 定</el-button>
            </span>
        </el-dialog>
        <!--创建修改查看弹窗结束-->
    </div>
</template>

<script>
    import vueJsonEditor from 'vue-json-editor';

    export default {
        //注入vueJsonEditor组件
        components: {
            vueJsonEditor
        },
        name: 'timeTaskList',
        data: function() {
            return {
                tableTabs: 'sendMail',//tab选中的值
                timeTaskList: [],//定时任务列表
                timeTaskCount: 0,//定时任务列表总条数
                page: 1,//页面
                pageSize: 10,//分页大小
                dialogVisible: false,//新增修改查看任务详细弹窗
                status: '',//当前弹窗状态
                timeTaskTitle: '',//弹窗标题
                timeTask: {
                    id: '',
                    taskName: '',
                    taskCategory: 1,
                    emailAddress: '',
                    requestAddress: '',
                    taskParam: {},
                    personInCharge: '',
                    emailContent: '',
                    createAdminId: localStorage.getItem('userId'),
                    modifyAdminId: localStorage.getItem('userId'),
                    isAppoin: 0,
                    frequency: 0,
                    appoinDate: '',
                    emailSubject: '',
                    requestMode: 1
                }
            };
        },
        methods: {
            deleteTimeTask(row){
                // 删除定时任务
                debugger
                this.assignmentFunc(row);
                debugger
                this.api.deleteTimeTask(this.timeTask).then(res => {
                    if (res.ret == true) {
                        this.$message({
                            message: res.msg,
                            type: 'success'
                        });
                        this.handleClose();
                        this.getTimeTaskList();
                    } else {
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                    }
                });
            },
            assignmentFunc(row){
                // 修改和查看赋值函数
                this.timeTask.id == row.id;
                this.timeTask.taskName = row.taskName;
                this.timeTask.taskCategory = row.taskCategory
                this.timeTask.emailAddress = row.emailAddress;
                this.timeTask.requestAddress = row.requestAddress;
                this.timeTask.taskParam = row.taskParam
                this.timeTask.personInCharge = row.personInCharge;
                this.timeTask.emailContent = row.emailContent
                this.timeTask.isAppoin = row.isAppoin
                this.timeTask.frequency = row.frequency
                this.timeTask.appoinDate = row.appoinDate
                this.timeTask.emailSubject =row.emailSubject
                this.timeTask.requestMode = row.requestMode
            },
            lookTimeTask(row){
              // 查看任务
                this.assignmentFunc(row);
                this.dialogVisible = true
                this.status = 'look'
                this.timeTaskTitle =  '查看定时任务'
            },
            editTimeTask(row){
              // 修改任务
                this.assignmentFunc(row);
                this.dialogVisible = true
                this.status = 'edit'
                this.timeTaskTitle =  '修改定时任务'
            },
            resetDialog(){
                // 重置弹窗内容
                this.timeTask.id == '';
                this.timeTask.taskName = '';
                this.timeTask.taskCategory = 1
                this.timeTask.emailAddress = '';
                this.timeTask.requestAddress = '';
                this.timeTask.taskParam = {}
                this.timeTask.personInCharge = '';
                this.timeTask.emailContent = ''
                this.timeTask.isAppoin = 0
                this.timeTask.frequency = 0
                this.timeTask.appoinDate = ''
                this.timeTask.emailSubject =''
                this.timeTask.requestMode = 1
            },
            handleClose() {
                // 关闭弹窗事件
                this.dialogVisible = false;
                this.status = '';
                this.timeTaskTitle = ''
                this.resetDialog();
            },
            checkSubmit() {
                // 检查必填项是否已经完全填好
                if (this.timeTask.taskName == '' || this.timeTask.taskName == undefined) {
                    this.$message({
                        message: '任务名必填',
                        type: 'warning'
                    });
                    return false;
                }
                if (this.timeTask.taskCategory == 1) {
                    // 发送邮件
                    if (this.timeTask.emailAddress == '' || this.timeTask.emailAddress == undefined) {
                        this.$message({
                            message: '邮箱地址必填',
                            type: 'warning'
                        });
                        return false;
                    }
                    if (this.timeTask.emailSubject == '' || this.timeTask.emailSubject == undefined) {
                        this.$message({
                            message: '邮件主题必填',
                            type: 'warning'
                        });
                        return false;
                    }
                    if (this.timeTask.emailContent == '' || this.timeTask.emailContent == undefined) {
                        this.$message({
                            message: '邮件内容必填',
                            type: 'warning'
                        });
                        return false;
                    }
                } else if (this.timeTask.taskCategory == 2) {
                    // 请求接口
                    if (this.timeTask.requestAddress == '' || this.timeTask.requestAddress == undefined) {
                        this.$message({
                            message: '请求地址必填',
                            type: 'warning'
                        });
                        return false;
                    }
                    if (this.timeTask.taskParam == '' || this.timeTask.taskParam == undefined || this.tool.isJson(this.timeTask.taskParam)) {
                        this.$message({
                            message: '请求参数必须为json格式，如无参数请填{}',
                            type: 'warning'
                        });
                        return false;
                    }
                }
                if (this.timeTask.isAppoin == 0) {
                    // 没有指定日期
                    if (this.timeTask.frequency == '' || this.timeTask.frequency == undefined || this.timeTask.frequency == 0) {
                        this.$message({
                            message: '执行频度不能为空且不能为0',
                            type: 'warning'
                        });
                        return false;
                    }
                } else if (this.timeTask.isAppoin == 1) {
                    // 有指定执行日期
                    if (this.timeTask.appoinDate == '' || this.timeTask.appoinDate == undefined) {
                        this.$message({
                            message: '指定的日期不能为空',
                            type: 'warning'
                        });
                        return false;
                    }
                }
                if (this.timeTask.personInCharge == '' || this.timeTask.personInCharge == undefined) {
                    this.$message({
                        message: '负责人不能为空',
                        type: 'warning'
                    });
                    return false;
                }
                return true;
            },
            saveTimeTask() {
                // 保存定时任务

                // 检查必填项是否已经填了
                let flag = this.checkSubmit();
                if (flag) {
                    this.api.ioeTimeTask(this.timeTask).then(res => {
                        if (res.ret == true) {
                            this.$message({
                                message: res.msg,
                                type: 'success'
                            });
                            this.handleClose();
                            this.getTimeTaskList();
                        } else {
                            this.$message({
                                message: res.msg,
                                type: 'warning'
                            });
                        }
                    });
                }
            },
            addTimeTask() {
                // 新增定时任务
                this.dialogVisible = true;
                this.status = 'add';
                this.timeTaskTitle = '新建定时任务';
            },
            tabClick(tab, event) {
                // 点击tab事件
                console.log('tabs', tab, event);
                this.resetSearch();
                this.getTimeTaskList();
            },
            resetSearch() {
                // 重置查询条件函数
                this.timeTaskList = [];
                this.timeTaskCount = 0;
                this.page = 1;
                this.pageSize = 10;
            },
            getTimeTaskList() {
                // 根据当前类型，当前用户获取定时任务列表
                var sendData = {
                    'userId': localStorage.getItem('userId'),
                    'page': this.page,
                    'pageSize': this.pageSize
                };
                switch (this.tableTabs) {
                    case 'sendMail': {
                        // 发送邮件
                        sendData.taskCategory = 1;
                        break;
                    }
                    case 'sendRequest': {
                        sendData.taskCategory = 2;
                        break;
                    }
                }
                this.api.getAllTaskByUserId(sendData).then(res => {
                    if (res.ret == true) {
                        this.timeTaskList = res.data.list;
                        this.timeTaskCount = res.data.count;
                    }
                });
            },
            pageSizeChange(val) {
                // 分页控件分页大小变化函数
                this.pageSize = val;
                this.getTimeTaskList();
            },
            pageChange(val) {
                // 分页控件页码变化函数
                this.page = val;
                this.getTimeTaskList();
            }
        },
        mounted() {
            this.getTimeTaskList();
            vueJsonEditor.props.mode.default = 'code';
        },
        filters: {
            formatDataStamp: function(timeStamp) {
                let format = 'Y/M/D h:m:s';
                var formateArr = ['Y', 'M', 'D', 'h', 'm', 's'];
                var returnArr = [];

                var date = new Date(timeStamp);
                returnArr.push(date.getFullYear());
                returnArr.push(date.getMonth() + 1);
                returnArr.push(date.getDate());

                returnArr.push(date.getHours());
                returnArr.push(date.getMinutes());
                returnArr.push(date.getSeconds());

                for (var i in returnArr) {
                    format = format.replace(formateArr[i], returnArr[i]);
                }
                return format;
            }
        }
    };
</script>

<style scoped>

</style>
