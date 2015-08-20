.class final Landroid/support/v4/speech/tts/TextToSpeechICSMR1$1;
.super Landroid/speech/tts/UtteranceProgressListener;
.source "TextToSpeechICSMR1.java"


# instance fields
.field final synthetic a:Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;


# virtual methods
.method public onDone(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$1;->a:Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;

    invoke-interface {v0, p1}, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;->a(Ljava/lang/String;)V

    .line 61
    return-void
.end method

.method public onError(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$1;->a:Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;

    invoke-interface {v0, p1}, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;->b(Ljava/lang/String;)V

    .line 56
    return-void
.end method

.method public onStart(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$1;->a:Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;

    invoke-interface {v0, p1}, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;->c(Ljava/lang/String;)V

    .line 51
    return-void
.end method
