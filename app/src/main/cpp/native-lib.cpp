#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_hiy_hiyplayer_page_SplashActivity_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";
    jclass jclass1 = env->GetObjectClass(thiz);
//     调用 native 的函数 传入string 返回新的string

    return env->NewStringUTF(hello.c_str());
}