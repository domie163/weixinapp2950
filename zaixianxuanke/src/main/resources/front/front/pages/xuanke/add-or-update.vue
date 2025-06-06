
<template>
	<view class="content">
		<form class="app-update-pv">
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#06A9FF","textAlign":"left"}'
                          class="title">审核</view>
                    <picker @change="xuankeYesnoTypesChange" :value="xuankeYesnoTypesIndex" :range="xuankeYesnoTypesOptions" range-key="indexName">
                        <view
                                :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#06A9FF","borderRadius":"16rpx","color":"#06A9FF","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
                                class="uni-input">{{ruleForm.xuankeYesnoTypes?ruleForm.xuankeYesnoValue:"请选择审核"}}</view>
                    </picker>
                </view>

			<view class="btn">
				<button
					:style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"#06A9FF","borderColor":"#409EFF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0","width":"70%","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'
					@tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="createTimeConfirm"
						  ref="createTime" themeColor="#333333"></w-picker>


	</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";

	export default {
		data() {
			return {
				cross: '',
                ro:{
					kechengId: false,
					xueshengId: false,
					xuankeYesnoTypes: false,
					createTime: false,
				},
				ruleForm: {
					kechengId: '',
					xueshengId: '',
					xuankeYesnoTypes: '',//数字
					xuankeYesnoValue: '',//数字对应的值
					createTime: '',
				},
				// 登陆用户信息
				user: {},
				xuankeYesnoTypesOptions: [],
				xuankeYesnoTypesIndex : 0,

			}
		},
		components: {
			wPicker
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {

		/*下拉框*/
			let xuankeYesnoTypesParams = {
				page: 1,
				limit: 100,
				dicCode: 'xuanke_yesno_types',
			}
			let xuankeYesnoTypes = await this.$api.page(`dictionary`, xuankeYesnoTypesParams);
			this.xuankeYesnoTypesOptions = xuankeYesnoTypes.data.list


			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				let res = await this.$api.info(`xuanke`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			if(options.xuankeId){
                this.ruleForm.xuankeId = options.xuankeId;
			}
			// 跨表
			// this.styleChange()
		},
		methods: {
			// 下拉变化
            xuankeYesnoTypesChange(e) {
            this.xuankeYesnoTypesIndex = e.target.value
            this.ruleForm.xuankeYesnoValue = this.xuankeYesnoTypesOptions[this.xuankeYesnoTypesIndex].indexName
            this.ruleForm.xuankeYesnoTypes = this.xuankeYesnoTypesOptions[this.xuankeYesnoTypesIndex].codeIndex
        },


			// styleChange() {
			// 	this.$nextTick(() => {
			// 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
			// 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
			// 		// })
			// 	})
			// },


			// 日期控件
			createTimeConfirm(val) {
                console.log(val)
                this.ruleForm.createTime = val.result;
                this.$forceUpdate();
            },




			getUUID() {
				return new Date().getTime();
			},
			async onSubmitTap() {
				if ((!this.ruleForm.xuankeYesnoTypes)) {
					this.$utils.msg(`审核不能为空`);
					return
				}
				if (this.ruleForm.id) {
					await this.$api.update(`xuanke`, this.ruleForm);
				} else {
					await this.$api.save(`xuanke`, this.ruleForm);
				}
                uni.setStorageSync('pingluenStateState', true);
                this.$utils.msgBack('提交成功');
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
			}
		}
	}
</script>

<style lang="scss" scoped>
	.container {
		padding: 20upx;
	}

	.content:after {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		content: '';
		background-attachment: fixed;
		background-size: cover;
		background-position: center;
	}

	textarea {
		border: 1upx solid #EEEEEE;
		border-radius: 20upx;
		padding: 20upx;
	}

	.title {
		width: 180upx;
	}

	.avator {
		width: 150upx;
		height: 60upx;
	}

	.right-input {
		flex: 1;
		text-align: left;
		padding: 0 24upx;
	}

	.cu-form-group.active {
		justify-content: space-between;
	}

	.btn {
		display: flex;
		align-items: center;
		justify-content: center;
		flex-wrap: wrap;
		padding: 20upx 0;
	}

	.cu-form-group {
		padding: 0 24upx;
		background-color: transparent;
		min-height: inherit;
	}

	.cu-form-group+.cu-form-group {
		border: 0;
	}

	.cu-form-group uni-input {
		padding: 0 30upx;
	}

	.uni-input {
		padding: 0 30upx;
	}

	.cu-form-group uni-textarea {
		padding: 30upx;
		margin: 0;
	}

	.cu-form-group uni-picker::after {
		line-height: 68rpx;
	}

	.select .uni-input {
		line-height: 68rpx;
	}

	.input .right-input {
		line-height: 68rpx;
	}
</style>