/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinax.kubernetes;

import org.ballerinalang.compiler.plugins.AbstractCompilerPlugin;
import org.ballerinalang.compiler.plugins.SupportedAnnotationPackages;
import org.ballerinalang.model.tree.AnnotationAttachmentNode;
import org.ballerinalang.model.tree.ServiceNode;
import org.ballerinalang.util.diagnostic.DiagnosticLog;
import org.wso2.ballerinalang.compiler.tree.BLangAnnotationAttachment;
import org.wso2.ballerinalang.compiler.tree.expressions.BLangAnnotAttachmentAttribute;

import java.nio.file.Path;
import java.util.List;

import static org.ballerinax.kubernetes.utils.KubeGenUtils.printInfo;
import static org.ballerinax.kubernetes.utils.KubeGenUtils.printInstruction;

/**
 * Compiler plugin to generate kubernetes artifacts.
 */
@SupportedAnnotationPackages(
        value = "ballerinax.kubernetes"
)
public class KubernetesPlugin extends AbstractCompilerPlugin {
    @Override
    public void init(DiagnosticLog diagnosticLog) {
        printInfo("Generating Kubernetes artifacts ...");
    }

    @Override
    public void process(ServiceNode serviceNode, List<AnnotationAttachmentNode> annotations) {
        printInfo("**kubernetes** service node: " + serviceNode.getName().getValue());
        for (AnnotationAttachmentNode attachmentNode : annotations) {
            printInstruction(attachmentNode.getAnnotationName().getValue());
            List<BLangAnnotAttachmentAttribute> bLangAnnotationAttachments = ((BLangAnnotationAttachment)
                    attachmentNode).attributes;
            for (BLangAnnotAttachmentAttribute annotationAttribute : bLangAnnotationAttachments) {
                printInfo(annotationAttribute.name.value);
                //Node annotationValue = annotationAttribute.getValue().getValue();
            }
            // This is how you can report compilation errors, warnings, and messages.
            //dlog.logDiagnostic(Diagnostic.Kind.WARNING, serviceNode.getPosition(), "Dummy warning message");
        }
    }

    @Override
    public void codeGenerated(Path binaryPath) {
//        String filePath = binaryPath.toAbsolutePath().toString();
//        String userDir = new File(filePath).getParentFile().getAbsolutePath();
//        try {
//            byte[] bFile = Files.readAllBytes(Paths.get(filePath));
//            ProgramFileReader reader = new ProgramFileReader();
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bFile);
//            ProgramFile programFile = reader.readProgram(byteArrayInputStream);
//            PackageInfo packageInfos[] = programFile.getPackageInfoEntries();
//            KubeAnnotationProcessor kubeAnnotationProcessor = new KubeAnnotationProcessor();
//            //iterate through packages
//            for (PackageInfo packageInfo : packageInfos) {
//                ServiceInfo serviceInfos[] = packageInfo.getServiceInfoEntries();
//                int deploymentCount = 0;
//
//                for (ServiceInfo serviceInfo : serviceInfos) {
//                    AnnAttachmentInfo serviceAnnotation = serviceInfo.getAnnotationAttachmentInfo
//                            (KubeGenConstants.KUBERNETES_ANNOTATION_PACKAGE,
//                                    KubeGenConstants.SERVICE_ANNOTATION);
//                    if (serviceInfo.getAnnotationAttachmentInfo
//                            (KubeGenConstants.KUBERNETES_ANNOTATION_PACKAGE,
//                                    KubeGenConstants.DEPLOYMENT_ANNOTATION) != null) {
//                        if (deploymentCount < 1) {
//                            deploymentCount += 1;
//                        } else {
//                            KubeGenUtils.printWarn("multiple deployment{} annotations detected. " +
//                                    "Ignoring annotation in service: " + serviceInfo.getName());
//                        }
//                    }
//                    if (serviceAnnotation != null) {
//                        printInfo("Processing svc{} annotation for:" + serviceInfo.getName());
//                        String targetPath = userDir + File.separator + "target" + File.separator + KubeGenUtils
//                                .extractBalxName(filePath)
//                                + File.separator;
//                        kubeAnnotationProcessor.processSvcAnnotationForService(serviceInfo, filePath, targetPath);
//                    }
//                }
//            }
//            //kubeAnnotationProcessor.processDeploymentAnnotationForService(deploymentAnnotatedService, filePath,
//            // targetPath);
//
//        } catch (IOException e) {
//            KubeGenUtils.printError("error occurred while reading balx file" + e.getMessage());
//        }
    }
}
