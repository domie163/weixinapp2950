<template>
    <view class="content">
        <view class="logo">
            <image
                    :style='{"boxShadow":"0 0 0px #59f43e","borderColor":"#ccc","borderRadius":"200rpx","borderWidth":"0px","width":"200rpx","borderStyle":"solid","url":"http://codegen.caihongy.cn/20201209/edd741a06b384d60b45a69c54119e273.jpg","isShow":true,"height":"200rpx"}'
                    src='http://localhost:8080/zaixianxuanke/img/logo.jpg' mode="aspectFill"></image>
        </view>
        <view class="uni-form-item uni-column">
            <input v-model="username" :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#06A9FF","borderRadius":"16rpx","color":"#06A9FF","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
        </view>
        <view class="uni-form-item uni-column">
            <input v-model="password" :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#06A9FF","borderRadius":"16rpx","color":"#06A9FF","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
        </view>
        <view v-if='false' class="code" style="display: flex;">
            <input style="flex: 1;" :style='{"padding":"0 20rpx","boxShadow":"0 0 12rpx rgba(30, 144, 255, 0)","margin":"20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.3)","color":"#333","textAlign":"left","borderRadius":"16rpx 0 0 16rpx","borderWidth":"0","width":"calc(100% - 168rpx)","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' type="text" placeholder="请输入验证码" />
            <view class="getCodeBt" :style='{"padding":"0","boxShadow":"0 0 12rpx rgba(30, 144, 255, 0)","margin":"20rpx 0","borderColor":"#1e90ff","backgroundColor":"#f5f5f5","borderRadius":"0","borderWidth":"2rpx 2rpx 2rpx 0","width":"168rpx","borderStyle":"solid","height":"80rpx"}' style="display: flex;justify-content: center;align-items: center;" @click="randomString(4)">
                <view v-for="(item, index) in codes" :key="index" :style="{color:item.color,transform:item.rotate,fontSize:item.size,padding: '0 3px',display:'inline-block'}">{{ item.num }}</view>
            </view>
        </view>
        <view class="uni-form-item uni-column" v-if="roleNum>1">
            <picker @change="optionsChange" :value="index" :range="options">
                <view class="uni-picker-type" :style='{"lineHeight":"80rpx","fontSize":"28rpx","color":"rgba(84, 170, 111, 1)","textAlign":"center"}'>{{options[index]}}</view>
            </picker>
        </view>
        <view>
            <button @tap="onLoginTap" type="primary" :style='{"borderColor":"#06A9FF","backgroundColor":"#06A9FF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0px 0 8rpx","fontSize":"32rpx","borderStyle":"solid","height":"88rpx"}'>登录</button>
        </view>
        <view class="links">
            <view class="link-highlight" @tap="onRegisterTap('xuesheng')" :style='{"color":"rgba(204, 204, 0, 1)","fontSize":"24rpx"}'>注册学生</view>
            <view>|</view>
            <view @tap="onForgetTap" :style='{"color":"rgba(204, 204, 0, 1)","fontSize":"24rpx"}'>忘记密码？</view>
        </view>
    </view>
</template>

<script>
    import menu from '@/utils/menu'

    export default {
        data() {
            return {
                username: '',
                password: '',
                codes: [{
                    num: 1,
                    color: '#000',
                    rotate: '10deg',
                    size: '16px'
                }, {
                    num: 2,
                    color: '#000',
                    rotate: '10deg',
                    size: '16px'
                }, {
                    num: 3,
                    color: '#000',
                    rotate: '10deg',
                    size: '16px'
                }, {
                    num: 4,
                    color: '#000',
                    rotate: '10deg',
                    size: '16px'
                }],
                options: [
                    '请选择登录学生类型'
                ],
                optionsValues: [
                    '',
                    'xuesheng',
                ],
                index: 0,
                roleNum:0
            }
        },
        onLoad() {
            let options = ['请选择登录学生类型'];
            let menus = menu.list();
            this.menuList = menus;
            for(let i=0;i<this.menuList.length;i++){
                if(this.menuList[i].hasFrontLogin=='是'){
                    options.push(this.menuList[i].roleName);
                    this.roleNum++;
                }
            }
            if(this.roleNum==1) {
                this.index = 1;
            }
            this.options = options;
            this.randomString(4)
            this.styleChange()
        },
        methods: {
            randomString(len = 4) {
                const chars = [
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                    'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                    'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
                    '3', '4', '5', '6', '7', '8', '9'
                ]
                const colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
                const sizes = ['28', '30', '32', '34', '36']

                for (let i = 0; i < len; i++) {
                    // 随机验证码
                    const key = Math.floor(Math.random() * chars.length)
                    this.codes[i].num = chars[key]
                    // 随机验证码颜色
                    let code = '#'
                    for (let j = 0; j < 6; j++) {
                        const key = Math.floor(Math.random() * colors.length)
                        code += colors[key]
                    }
                    this.codes[i].color = code
                    // 随机验证码方向
                    let rotate = Math.floor(Math.random() * 30)
                    const plus = Math.floor(Math.random() * 2)
                    if (plus == 1) rotate = '-' + rotate
                    this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
                    // 随机验证码字体大小
                    const size = Math.floor(Math.random() * sizes.length)
                    this.codes[i].size = sizes[size] +'rpx'
                }
            },
            styleChange() {
                this.$nextTick(()=>{
                    // document.querySelectorAll('.uni-yaoxianStyle .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
                    //   el.style.backgroundColor = this.loginFrom.content.yaoxianStyle.backgroundColor
                    // })
                })
            },
            onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
                this.$utils.jump('../register/register')
            },
            onForgetTap() {
                this.$utils.jump('../forget/forget')
            },
           
			 async onLoginTap() {
                if (!this.optionsValues[this.index]) {
                    this.$utils.msg("请选择登陆${firstRegisterComment}类型")
                    return
                }
                let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
                    username: this.username,
                    password: this.password
                });
                uni.setStorageSync("token", res.token);
                uni.setStorageSync("nickname",this.username);
                uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
                res = await this.$api.session(`${this.optionsValues[this.index]}`);
                // 保存${firstRegisterComment}id
                uni.setStorageSync("userid", res.data.id);
                if(res.data.vip) {
                    uni.setStorageSync("vip", res.data.vip);
                }
                uni.setStorageSync("role", `${this.options[this.index]}`);
                this.$utils.tab("../index/index");
            },
			
            optionsChange(e) {
                this.index = e.target.value
            }
        }
    }
</script>

<style lang="scss" scoped>
    $color-primary: #b49950;

    .content {
        padding: 0 100upx;
        display: flex;
        justify-content: center;
        flex-direction: column;
        height: calc(100vh - 44px);
        box-sizing: border-box;
    }

    .content:after {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        content: '';
        background-image: url(http://localhost:8080/zaixianxuanke/img/front-img-bg.jpg);
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
    }

    .logo {
        text-align: center;

    image {
        height: 200upx;
        width: 200upx;
        margin: 0 0 60upx;
    }
    }

    .uni-form-item {
        margin-bottom: 40upx;
        padding: 0;

    .uni-input {
        font-size: 30upx;
        padding: 7px 0;
    }
    }

    button[type="primary"] {
        background-color: $color-primary;
        border-radius: 0;
        font-size: 34upx;
        margin-top: 60upx;
    }

    .links {
        text-align: center;
        margin-top: 40upx;
        font-size: 26upx;
        color: #999;

    view {
        display: inline-block;
        vertical-align: top;
        margin: 0 10upx;
    }

    .link-highlight {
        margin: 0;
        color: $color-primary
    }
    }
</style>
