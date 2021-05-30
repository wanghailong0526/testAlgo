#include <jni.h>
#include <string>
// NDK工具链里面的 log 库 引入过来
#include <android/log.h>

#define TAG "whl"
// ... 我都不知道传入什么  借助JNI里面的宏来自动帮我填充
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, TAG, __VA_ARGS__)

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_textjni_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_textjni_MainActivity_changeName(JNIEnv *env, jobject thiz) {
    //修改java的name
    //1.获取jclass
    jclass pJclass = env->GetObjectClass(thiz);
    //2.获取属性
    jfieldID pFId = env->GetFieldID(pJclass, "name", "Ljava/lang/String;");
    //3.获取java层的name值
    jstring jstrname = static_cast<jstring>(env->GetObjectField(thiz, pFId));
//    LOGE("name 修改前:",jstrname);//这样打印不了，因为此时在c++层，需要char *
    //4.将jstring 转换为 char *
    const char *string = env->GetStringUTFChars(jstrname, NULL);
    LOGE("native name修改前：%s", string);
    //5.生成新的jstring
    jstring pJname = env->NewStringUTF("beyond");
    //6.为java层name设置新的值
    env->SetObjectField(thiz, pFId, pJname);
    env->DeleteLocalRef(jstrname);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_textjni_MainActivity_changeAge(JNIEnv *env, jclass clazz) {
    char *sign = "I";
    jfieldID pFId = env->GetStaticFieldID(clazz, "age", sign);
    jint age = env->GetStaticIntField(clazz, pFId);

    LOGE("age修改前：%d", age);
    age += 10;
    env->SetStaticIntField(clazz, pFId, age);
    LOGE("age修改后：%d", age);

}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_textjni_MainActivity_callAddMethod(JNIEnv *env, jobject thiz) {
    char * sign = "(II)I";
    jclass pJclass = env->GetObjectClass(thiz);
    jmethodID pMId = env->GetMethodID(pJclass, "add", sign);
    jint i = env->CallIntMethod(thiz, pMId,8,8);
    LOGE("调用 add方法结果：%d",i);
}